package com.febin.mycomponents

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipComponents(
    modifier: Modifier,
    text: String,
    onDismiss: () -> Unit,
) {
    var selected by remember { mutableStateOf(false) }

    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

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
                        .height(10.dp)
                )
                // Assist Chip Component
                AssistChip(
                    onClick = { Log.d("Assist chip", "hello world") },
                    label = { Text("Assist chip") },
//            modifier.background(Color.White),
                    colors = AssistChipDefaults.assistChipColors(
                        containerColor = Color.White,
                        labelColor = Color.Black
                    ),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Settings,
                            contentDescription = "Localized description",
                            modifier = Modifier
                                .background(Color.White)
                                .size(FilterChipDefaults.IconSize),
                            tint = Color.Black
                        )
                    }
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                // Filter Chip Component
                FilterChip(
                    onClick = { selected = !selected },
                    label = {
                        Text("Filter chip")
                    },
                    modifier = Modifier,
                    selected = selected,
                    leadingIcon = if (selected) {
                        {
                            Icon(
                                imageVector = Icons.Filled.Done,
                                contentDescription = "Done icon",
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else {
                        null
                    },
                    colors = FilterChipDefaults.filterChipColors(Color.White)

                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                // Input Chip Component
                InputChip(
                    onClick = {
                        onDismiss()
                        enabled = !enabled
                    },
                    label = { Text(text) },
                    selected = enabled,
                    avatar = {
                        Icon(
                            Icons.Filled.Person,
                            contentDescription = "Localized description",
                            Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Default.Close,
                            contentDescription = "Localized description",
                            Modifier.size(InputChipDefaults.AvatarSize)
                        )
                    },
                )

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                )

                // Input Chip Component
                SuggestionChip(
                    onClick = { Log.d("Suggestion chip", "hello world") },
                    label = { Text("Suggestion chip") },
                    colors = SuggestionChipDefaults.suggestionChipColors(Color.White)
                )


            }

        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ChipComponentsPreview() {
    ChipComponents(
        modifier = Modifier,
        text = "Filter chip",
        onDismiss = { /*TODO*/ }
    )
}