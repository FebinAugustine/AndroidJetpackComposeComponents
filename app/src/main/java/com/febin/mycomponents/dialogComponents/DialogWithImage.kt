package com.febin.mycomponents.dialogComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.febin.mycomponents.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogWithImageComp(
    modifier: Modifier,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var openDialog by rememberSaveable { mutableStateOf(false) }
        var text by remember { mutableStateOf("") }

        Button(onClick = { openDialog = true }) {
            Text(text = "Open Dialog With Image")
        }

        if (openDialog) {
            Dialog(onDismissRequest = { openDialog = false }) {
                // Draw a rectangle shape with rounded corners inside the dialog
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(375.dp)
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_launcher_background),
                            contentDescription = "imageDescription",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(160.dp)
                        )
                        Text(
                            text = "This is a dialog with buttons and an image.",
                            modifier = Modifier.padding(16.dp),
                        )
                        TextField(value = text, onValueChange = { text = it })
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                        ) {

                            TextButton(
                                onClick = { openDialog = false },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Dismiss")
                            }
                            TextButton(
                                onClick = { openDialog = false },
                                modifier = Modifier.padding(8.dp),
                            ) {
                                Text("Confirm")
                            }
                        }
                    }
                }
            }
        }

    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DialogWithImageCompPreview() {
    DialogWithImageComp(
        modifier = Modifier,

        )
}