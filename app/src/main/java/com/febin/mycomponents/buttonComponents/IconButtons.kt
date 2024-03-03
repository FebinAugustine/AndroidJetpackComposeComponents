package com.febin.mycomponents.buttonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
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


@Composable
fun IconButtons(
    onClick: () -> Unit,
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
                Text(text = "Icon Buttons")
                // Icon Button Component
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }


                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Filled Icon Buttons")
                // Filled Icon Button Component
                FilledIconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Filled Icon Toggle Buttons")
                // Filled Icon Toggle Button Component
                var checked by remember { mutableStateOf(false) }
                FilledIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    if (checked) {
                        Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                    } else {
                        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                    }
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Icon Toggle Button ")
                // Icon Toggle Icon Button Component
//                var checked by remember { mutableStateOf(false) }
                IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    if (checked) {
                        Icon(Icons.Filled.Settings, contentDescription = "Localized description")
                    } else {
                        Icon(Icons.Outlined.Settings, contentDescription = "Localized description")
                    }
                }


                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Filled Tonal Icon Buttons")
                // Filled Tonal Icon Button Component
                FilledTonalIconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }


                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Filled Tonal Icon Toggle Buttons")
                // Filled Tonal Icon Toggle Button Component
//                var checked by remember { mutableStateOf(false) }
                FilledTonalIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    if (checked) {
                        Icon(Icons.Filled.Lock, contentDescription = "Localized description")
                    } else {
                        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                    }
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Outlined Icon Buttons")
                // Outlined Icon Button Component
                OutlinedIconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                Text(text = "Outlined Icon Toggle Buttons")
                // Outlined Icon Toggle Button Component
//                var checked by remember { mutableStateOf(false) }
                OutlinedIconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    if (checked) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    } else {
                        Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                    }
                }



            }

        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IconButtonsPreview() {
    IconButtons(
        onClick = { /*TODO*/ },
        modifier = Modifier,
    )
}