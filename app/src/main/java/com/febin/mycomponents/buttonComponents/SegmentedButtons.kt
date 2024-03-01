package com.febin.mycomponents.buttonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SegmentedButtons(
    modifier: Modifier,
) {
    Box(
        modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(10.dp)

    ) {
        LazyColumn() {
            item {

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                // Segmented Button Component

                var selectedIndex by remember { mutableIntStateOf(0) }
                val options = listOf("Day", "Month", "Week")
                SingleChoiceSegmentedButtonRow {
                    options.forEachIndexed { index, label ->
                        SegmentedButton(
                            shape = SegmentedButtonDefaults.itemShape(
                                index = index,
                                count = options.size
                            ),
                            onClick = { selectedIndex = index },
                            selected = index == selectedIndex
                        ) {
                            Text(
                                text = label,
                                style = MaterialTheme.typography.labelMedium
                            )
                        }
                    }
                }


            }

        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SegmentedButtonsPreview() {
    SegmentedButtons(
        modifier = Modifier,
    )
}