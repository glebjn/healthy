package com.i.records_impl

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecordScreen() {
    Column {
        var date by remember { mutableStateOf("") }
        TextField(
            value = date,
            onValueChange = { text ->
                date = text
            },
            placeholder = {
                val text = stringResource(id = R.string.add_record_date_hint)
                Text(text)
            }
        )

        var pressure by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.padding(top = 16.dp),
            value = pressure,
            onValueChange = { text ->
                pressure = text
            },
            placeholder = {
                val text = stringResource(id = R.string.add_record_pressure_hint)
                Text(text)
            }
        )

        var feelings by remember { mutableStateOf("") }
        TextField(
            modifier = Modifier.padding(top = 16.dp),
            value = feelings,
            onValueChange = { text ->
                feelings = text
            },
            placeholder = {
                val text = stringResource(id = R.string.add_record_feelings_hint)
                Text(text)
            }
        )
    }
}

@Preview
@Composable
fun AddRecordPreview() {
    MaterialTheme {
        AddRecordScreen()
    }
}