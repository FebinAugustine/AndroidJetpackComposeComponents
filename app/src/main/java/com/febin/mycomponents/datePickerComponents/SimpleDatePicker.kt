package com.febin.mycomponents.datePickerComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DateFormat
import java.util.Date


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDatePicker(
    modifier: Modifier,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Pre-select a date for January 4, 2020
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)
        val date = datePickerState.selectedDateMillis?.let { Date(it) }
        // Format the date as desired
        val formattedDate = date?.let { DateFormat.getDateInstance().format(it) }
        DatePicker(
            state = datePickerState,
            modifier = Modifier
                .padding(16.dp),
        )

        Text(
            text = "Selected date: $formattedDate",
        )


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SimpleDatePickerPreview() {
    SimpleDatePicker(
        modifier = Modifier,

        )
}

