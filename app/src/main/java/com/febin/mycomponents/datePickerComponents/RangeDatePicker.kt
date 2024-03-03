package com.febin.mycomponents.datePickerComponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RangeDatePicker(
    modifier: Modifier,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Decoupled snackbar host state from scaffold state for demo purposes.
        val snackState = remember { SnackbarHostState() }
        val snackScope = rememberCoroutineScope()
        SnackbarHost(hostState = snackState, Modifier.zIndex(1f))

        val state = rememberDateRangePickerState()
        val openDialog = remember { mutableStateOf(false) }
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
            // Add a row with "Save" and dismiss actions.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        if (openDialog.value) {
                            openDialog.value = false
                        } else {
                            openDialog.value = true
                        }
                    }
                ) {
                    Icon(Icons.Filled.Menu,
                        contentDescription = "Localized description")
                }
                IconButton(onClick = { openDialog.value = false }) {
                    Icon(
                        Icons.Filled.Close,

                        contentDescription = "Localized description")
                }
                TextButton(
                    onClick = {
                        openDialog.value = false
                        snackScope.launch {
                            snackState.showSnackbar(
                                "Saved range (timestamps): " +
                                        "${state.selectedStartDateMillis!!..state.selectedEndDateMillis!!}"
                            )
                        }
                    },
                    enabled = state.selectedEndDateMillis != null
                ) {
                    Text(text = "Save")
                }
            }

            if(openDialog.value) {
                DateRangePicker(state = state, modifier = Modifier.weight(1f))
            } else openDialog.value = false




        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RangeDatePickerPreview() {
    RangeDatePicker(
        modifier = Modifier,

        )
}

