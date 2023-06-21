package com.i.records_impl.core

import com.i.records_impl.addrecord.map

internal class RecordsRepositoryImpl(
    private val recordService: RecordService
) : RecordsRepository {

    override fun createRecords(record: Record) {
        val request = record.map()
        recordService.createRecord(request)
    }

    override fun getRecords() {

    }

    override fun getRecordById(id: Long) {

    }
}