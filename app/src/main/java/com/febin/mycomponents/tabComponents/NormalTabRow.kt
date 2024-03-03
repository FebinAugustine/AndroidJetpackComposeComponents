package com.febin.mycomponents.tabComponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.SecondaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NormalTabRow(
    modifier: Modifier,
) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                // PrimaryTab Row
                //For primary indicator tabs, use PrimaryTabRow. For secondary indicator tabs, use SecondaryTabRow.

                var state by remember { mutableIntStateOf(0) }
                val titles = listOf("Tab 1", "Tab 2", "Tab 3", "Tab with lots of text")
                Column {
                    PrimaryTabRow(
                        selectedTabIndex = state
                    ) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                text = {
                                    Text(
                                        text = title,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Primary tab ${state + 1} selected",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Primary Scrollable TabRow

                    PrimaryScrollableTabRow(selectedTabIndex = state) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Primary Scrollable tab ${state + 1} selected",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // Secondary TabRow

                    SecondaryTabRow(selectedTabIndex = state) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Secondary tab ${state + 1} selected",
                        style = MaterialTheme.typography.bodyLarge
                    )




                    Spacer(modifier = Modifier.height(16.dp))

                    // Scrollable TabRow

                    ScrollableTabRow(selectedTabIndex = state) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Scrollable tab ${state + 1} selected",
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Scrollable Secondary TabRow

                    SecondaryScrollableTabRow(selectedTabIndex = state) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                            )
                        }
                    }
                    Text(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "Secondary Scrollable tab ${state + 1} selected",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }


            }
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NormalTabRowPreview() {
    NormalTabRow(
        modifier = Modifier,
    )
}