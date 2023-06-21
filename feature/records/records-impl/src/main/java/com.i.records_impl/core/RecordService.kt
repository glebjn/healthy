package com.i.records_impl.core

import retrofit2.http.POST

interface RecordService {

    @POST("/createRecord")
    fun createRecord(record: RecordRequest)
}