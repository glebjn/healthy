package com.i.records_impl.core

interface RecordsRepository {
    fun createRecords(record: Record)
    fun getRecords()
    fun getRecordById(id: Long)
}