package com.febin.mycomponents.menuComponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    modifier: Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .wrapContentSize(Alignment.TopStart)
        ) {
            IconButton(
                modifier = modifier,

                onClick = { expanded = true }) {
                Icon(
                    Icons.Outlined.MoreVert,
                    contentDescription = "Click To See Drop Down"
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Edit") },
                    onClick = { /* Handle edit! */ },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = "Click To Edit Item"
                        )
                    })
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { /* Handle settings! */ },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Settings,
                            contentDescription = "Click To Go to Settings"
                        )
                    })
                HorizontalDivider()
                DropdownMenuItem(
                    text = { Text("Send Feedback") },
                    onClick = { /* Handle send feedback! */ },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Email,
                            contentDescription = "Click To Send Feedback"
                        )
                    },
                    trailingIcon = { Text("F11",
                        textAlign = TextAlign.Center) })
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DropDownMenuPreview() {
    DropDownMenu(
        modifier = Modifier,
    )
}