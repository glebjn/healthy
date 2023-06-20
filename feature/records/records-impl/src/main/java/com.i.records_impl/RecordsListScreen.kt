package com.i.records_impl

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordsListScreen(
    onAddRecordClicked: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddRecordClicked() }
            ) {

            }
        }
    ) { contentPadding ->
        contentPadding
    }
}

@Preview
@Composable
fun RecordsListScreenPreview() {
    MaterialTheme {
        RecordsListScreen {}
    }
}