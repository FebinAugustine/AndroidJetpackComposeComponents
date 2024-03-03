package com.febin.mycomponents.badgeBoxComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgeBoxComp(
    modifier: Modifier,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        BadgedBox(
            badge = {
                Badge {
                    val badgeNumber = "100"
                    Text(
                        badgeNumber,
                        modifier = Modifier.semantics {
                            contentDescription = "$badgeNumber new notifications"
                        }
                    )
                }
            }) {
            Icon(
                Icons.Filled.Star,
                contentDescription = "Favorite"
            )


        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BadgeBoxCompPreview() {
    BadgeBoxComp(
        modifier = Modifier,

        )
}