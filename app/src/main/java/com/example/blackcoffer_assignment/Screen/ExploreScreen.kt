package com.example.blackcoffer_assignment.Screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blackcoffer_assignment.R
import com.example.blackcoffer_assignment.ui.theme.Blackcoffer_AssignmentTheme



@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ExploreScreen(modifier: Modifier = Modifier,navController: NavHostController) {
    val tabItems = listOf("Personal", "Service  ", "Business")

    Scaffold(floatingActionButton = { FloatingActionButton(shape = CircleShape,containerColor = Color(0xFF143D58),contentColor = Color.White,onClick = { /*TODO*/ }) {
        Icon(
         imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.White
        )
        
    }},topBar = {
        TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
            Color(0xFF143D58)
        ), title = {
            Column {
                Text(
                    text = "Howdy Manas Patil!!",
                    fontSize = 12.sp,
                    color = Color.White
                )
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier.size(12.dp),
                        tint = Color.White
                    )
                    Text(text = "Mumbai, India", fontSize = 12.sp, color = Color.White)
                }
            }
        }, actions = {
            IconButton(onClick = { navController.navigate("setting") }) {
                Icon(
                    painter = painterResource(id = R.drawable.refine),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        }, navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.menu),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        })
    }) { it ->
        var SelectableTabIndex by remember {
            mutableStateOf(0)
        }
        val pagerState = rememberPagerState { tabItems.size }
        LaunchedEffect(SelectableTabIndex) { pagerState.animateScrollToPage(SelectableTabIndex) }
        LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress) SelectableTabIndex = pagerState.currentPage
        }
        Column(modifier = Modifier.padding(it)) {
            TabRow(
                selectedTabIndex = SelectableTabIndex,
                containerColor = Color(0xFF143D58).copy(alpha = 0.97f),
                contentColor = Color.White,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[SelectableTabIndex]),
                        height = 4.dp,
                        color = Color.White
                    )
                }
            ) {
                tabItems.forEachIndexed { index, item ->
                    Tab(
                        selected = index == SelectableTabIndex,
                        onClick = { SelectableTabIndex = index },
                        text = { Text(text = item.toString()) },
                        unselectedContentColor = Color.Gray, selectedContentColor = Color.White,

                        )
                }

            }
            HorizontalPager(
                state = pagerState, modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(Modifier.fillMaxWidth()) {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.align(Alignment.TopStart)

                        ) {
                            OutlinedCard(
                                modifier = Modifier
                                    .padding(18.dp)
                                    .height(45.dp)
                            ) {

                                TextField(
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = null
                                        )
                                    },
                                    value = "",
                                    onValueChange = {},
                                    placeholder = { Text("search", fontSize = 12.sp) },
                                    modifier = Modifier.width(310.dp)
                                )
                            }
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.setting),
                                    contentDescription = null,
                                    modifier = Modifier.size(35.dp),
                                )

                            }
                        }

                    }
                    LazyColumn(){
                        items(10){
                            when
                                (SelectableTabIndex) {
                                    0 -> CustomUserCard(modifier = Modifier)
                                    1 -> CustomUserCard(modifier = Modifier,"Serivce Name")
                                2 -> CustomUserCard(modifier = Modifier, "Business Name")

                            }

                            Spacer(modifier = Modifier.height(10.dp))

                        }
                    }

                }
            }
        }
    }

}

