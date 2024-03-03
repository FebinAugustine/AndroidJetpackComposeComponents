package com.febin.mycomponents.navigationComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationBarComp(
    modifier: Modifier = Modifier,
) {




    Scaffold(

    ) { contentPadding ->
        // Screen content
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()

        ) {
            var selectedItem by remember { mutableIntStateOf(0) }
            val items = listOf("Songs", "Artists", "Playlists")

            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
            Text(text = "Selected item: ${items[selectedItem]}")

        }
    }


}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavigationBarCompPreview() {
    NavigationBarComp(modifier = Modifier.fillMaxSize())
}