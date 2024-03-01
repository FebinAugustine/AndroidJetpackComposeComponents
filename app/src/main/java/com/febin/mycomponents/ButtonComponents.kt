package com.febin.mycomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonComponents(
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(10.dp)

    ) {
        LazyColumn() {
            item {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )

                // Normal Button Component
                Button(
                    onClick = { onClick() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Filled")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                // Filled Tonal Button Component
                FilledTonalButton(
                    onClick = { onClick() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Filled Tonal Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                // Outlined Button Component
                OutlinedButton(
                    onClick = { onClick() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Outlined Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                // Elevated Button Component
                ElevatedButton(
                    onClick = { onClick() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Elevated Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )
                // Text Button Component
                TextButton(
                    onClick = { onClick() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Text Button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ButtonComponentsPreview() {
    ButtonComponents(
        onClick = { /*TODO*/ },
        modifier = Modifier,
    )
}