package com.i.records_impl.core

import retrofit2.http.GET
import retrofit2.http.POST

interface RecordService {

    @GET("records")
    suspend fun getRecords(): List<RecordResponse>

    @POST("createRecord")
    suspend fun createRecord(record: RecordRequest)
}