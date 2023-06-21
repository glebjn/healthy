package com.i.records_impl.di

import com.i.records_impl.addrecord.AddRecordUseCase
import com.i.records_impl.addrecord.AddRecordUseCaseImpl
import com.i.records_impl.addrecord.AddRecordViewModel
import com.i.records_impl.core.RecordService
import com.i.records_impl.core.RecordsRepository
import com.i.records_impl.core.RecordsRepositoryImpl
import com.i.records_impl.recordlist.GetRecordsListUseCase
import com.i.records_impl.recordlist.GetRecordsListUseCaseImpl
import com.i.records_impl.recordlist.RecordListViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val recordsModule = module {
    provideDomain()
    provideUi()
}

private fun Module.provideDomain() {
    single<RecordService> {
        val okhttpClient = provideOkHttpClient()
        provideRecordApiService(okhttpClient)
    }
    single<RecordsRepository> { RecordsRepositoryImpl(get()) }
    factory<AddRecordUseCase> { AddRecordUseCaseImpl(get()) }
    factory<GetRecordsListUseCase> { GetRecordsListUseCaseImpl(get()) }
}

private fun Module.provideUi() {
    viewModelOf(::AddRecordViewModel)
    viewModelOf(::RecordListViewModel)
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()
}

private fun provideRecordApiService(okhttp: OkHttpClient): RecordService {
    val contentType = "application/json".toMediaType()
    return Retrofit.Builder().client(okhttp)
        .baseUrl("http://google.com")
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build().create(RecordService::class.java)
}