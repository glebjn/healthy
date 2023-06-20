package com.i.records_impl

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecordsListScreen(onNextScreen: (id: Long) -> Unit) {

}

@Preview
@Composable
fun RecordsListScreenPreview() {
    MaterialTheme {
        RecordsListScreen {}
    }
}