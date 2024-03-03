package com.febin.mycomponents.sliderComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SliderComponents(
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

                // Basic Slider Component
                var sliderPosition by remember { mutableFloatStateOf(0f) }
                Column {
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it }
                    )
                    Text(text = sliderPosition.toString())
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                // Slider with 3 positions Component
                Column {
                    Slider(
                        value = sliderPosition,
                        onValueChange = { sliderPosition = it },
                        colors = SliderDefaults.colors(
                            thumbColor = MaterialTheme.colorScheme.secondary,
                            activeTrackColor = MaterialTheme.colorScheme.secondary,
                            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
                        ),
                        steps = 3,
                        valueRange = 0f..50f
                    )
                    Text(text = sliderPosition.toString())
                }


            }

        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SliderComponentsPreview() {
    SliderComponents(
        modifier = Modifier,
    )
}