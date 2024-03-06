package com.febin.mycomponents.advancedComponents.tabWithPager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun TabWithPagerComp(
    modifier: Modifier = Modifier,
) {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    val pagerState = rememberPagerState {
        tabData2.size
    }

    LaunchedEffect(selectedTabIndex) {
        pagerState.scrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage

    }



    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,

                contentColor = MaterialTheme.colorScheme.contentColorFor(MaterialTheme.colorScheme.onSurface),

                ) {
                tabData2.forEachIndexed { index, item ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(text = item.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedTabIndex) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title,
                            )
                        }
                    )

                }

            }

            // Pager Content Starts Here
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                ) { index ->

                    val item = tabData2[index]

                    when (item.title) {
                        "Tab 1" -> {
                           /* Call your composable function here */
                            Text(text = "Tab 1")
                        }
                        "Tab 2" -> {
                            /* Call your composable function here */
                            Text(text = "Tab 2")
                        }
                        "Tab 3" -> {
                            /* Call your composable function here */
                            Text(text = "Tab 3")
                        }

                    }

                }
            }

        }
    }


}


// You have to include this Tab Items List in your View Model
// List of tab items
private val tabItems2 = listOf(
    TabItem(
        title = "Tab 1",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home,
    ),

    TabItem(
        title = "Tab 2",
        unselectedIcon = Icons.Outlined.ShoppingCart,
        selectedIcon = Icons.Filled.ShoppingCart,
    ),

    TabItem(
        title = "Tab 3",
        unselectedIcon = Icons.Outlined.Notifications,
        selectedIcon = Icons.Filled.Notifications,
    ),


)
val tabData2: List<TabItem> = tabItems2

data class TabItems(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TabWithPagerCompPreview() {
    TabWithPagerComp(modifier = Modifier.fillMaxSize())
}