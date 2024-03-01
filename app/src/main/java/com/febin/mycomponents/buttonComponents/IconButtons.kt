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
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
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
                // Icon Button Component

                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.Lock, contentDescription = "Localized description")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                // Toggle Icon Button Component

                var checked by remember { mutableStateOf(false) }
                IconToggleButton(checked = checked, onCheckedChange = { checked = it }) {
                    if (checked) {
                        Icon(Icons.Filled.Settings, contentDescription = "Localized description")
                    } else {
                        Icon(Icons.Outlined.Settings, contentDescription = "Localized description")
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