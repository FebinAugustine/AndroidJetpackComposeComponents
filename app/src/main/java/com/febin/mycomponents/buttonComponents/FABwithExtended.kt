package com.febin.mycomponents.buttonComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun FABwithExtended(
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
                        .height(10.dp)
                )
                // Normal Floating Action Button Component

                FloatingActionButton(
                    onClick = { onClick() },
                ) {
                    Icon(Icons.Filled.Add, "Floating action button.")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
                // Small Floating Action Button Component
                SmallFloatingActionButton(
                    onClick = { onClick() },
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.secondary
                ) {
                    Icon(Icons.Filled.Add, "Small floating action button.")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )

                // Large Floating Action Button Component
                LargeFloatingActionButton(
                    onClick = { onClick() },
                    shape = CircleShape,
                ) {
                    Icon(Icons.Filled.Add, "Large floating action button")
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )

                // Extended Floating Action Button 2
                ExtendedFloatingActionButton(
                    onClick = { onClick() },
                    icon = { Icon(Icons.Filled.Edit, "Extended floating action button 2.") },
                    text = { Text(text = "Extended FAB") },
                )


            }

        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FABwithExtendedPreview() {
    FABwithExtended(
        onClick = { /*TODO*/ },
        modifier = Modifier,
    )
}