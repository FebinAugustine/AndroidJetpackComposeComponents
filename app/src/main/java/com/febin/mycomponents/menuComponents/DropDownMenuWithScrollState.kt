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
fun DropDownMenuWithScrollState(
    modifier: Modifier,
) {
    var expanded by remember { mutableStateOf(false) }

//    var expanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentSize(Alignment.TopStart)
    ) {
        IconButton(onClick = { expanded = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Localized description")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            scrollState = scrollState
        ) {
            repeat(10) {
                DropdownMenuItem(
                    text = { Text("Item ${it + 1}") },
                    onClick = { /* TODO */ },
                    leadingIcon = {
                        Icon(
                            Icons.Outlined.Edit,
                            contentDescription = null
                        )
                    })
            }
        }
        LaunchedEffect(expanded) {
            if (expanded) {
                // Scroll to show the bottom menu items.
                scrollState.scrollTo(scrollState.maxValue)
            }
        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DropDownMenuWithScrollStatePreview() {
    DropDownMenuWithScrollState(
        modifier = Modifier,
    )
}