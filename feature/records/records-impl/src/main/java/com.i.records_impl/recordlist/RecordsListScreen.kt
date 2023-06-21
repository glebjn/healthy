package com.i.records_impl.recordlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.i.records_impl.core.Record
import org.koin.androidx.compose.koinViewModel

@Composable
fun RecordsListScreen(
    onAddRecordClicked: () -> Unit
) {
    RecordsListUi(onAddRecordClicked)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordsListUi(
    onAddRecordClicked: () -> Unit
) {
    val viewModel: RecordListViewModel = koinViewModel()
    val records = viewModel.records.collectAsState().value
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddRecordClicked() }
            ) {
                Column {
                    records.forEach { record ->
                        RecordItemRow(record)
                    }
                }
            }
        }
    ) { contentPadding ->
        contentPadding
    }
}

@Composable
fun RecordItemRow(record: Record) {
    Column {
        Text(text = record.date)
        Text(text = record.pressure)
        Text(text = record.feelings)
    }
}

@Preview
@Composable
fun RecordsListScreenPreview() {
    MaterialTheme {
        RecordsListUi {}
    }
}