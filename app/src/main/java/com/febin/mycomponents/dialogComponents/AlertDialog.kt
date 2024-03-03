package com.febin.mycomponents.dialogComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogComp(
    modifier: Modifier,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var openDialog by rememberSaveable { mutableStateOf(false) }

        Button(onClick = { openDialog = true }) {
            Text(text = "Open Dialog")
        }

        if (openDialog) {
            AlertDialog(
                title = {
                    Text(text = "dialogTitle")
                },
                text = {
                    Text(text = "dialogText")
                },
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                        }
                    ) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openDialog = false
                        }
                    ) {
                        Text("Dismiss")
                    }
                }
            )
        }

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlertDialogCompPreview() {
    AlertDialogComp(
        modifier = Modifier,

        )
}