package com.example.blackcoffer_assignment.Screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavHostController
import com.example.blackcoffer_assignment.R

import com.example.blackcoffer_assignment.ui.theme.Blackcoffer_AssignmentTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Refine(modifier: Modifier,navController:NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Refine",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                            tint = Color.White
                        )

                    }
                }, colors = topAppBarColors(
                    Color(0xFF143D58)
                )
            )
        }) { it ->
        Column(modifier = Modifier.padding(it)) {
            var mExpanded by remember { mutableStateOf(false) }
            val availability = listOf(
                "Available | Hey Let Use Connect",
                "Away | Stay Discrete And Watch",
                "Busy | Do Not Disturb I Will Catch Up Later",
                "SOS | Emergency! Need Assistance! HELP"
            )
            var mSelectedText by remember { mutableStateOf("Available | Hey Let Use Connect") }
            val icon = if (mExpanded)
                Icons.Filled.KeyboardArrowUp
            else
                Icons.Filled.KeyboardArrowDown
            var mTextFild by remember { mutableStateOf("I am open to new connections") }
            var sliderPosition by remember { mutableStateOf(1f) }

            Text(
                text = "Select Your Availability",
                style = TextStyle(
                    fontSize = 15.5.sp,
                    fontFamily = FontFamily(Font(R.font.inter_font)),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF405058),
                ),
                modifier = Modifier.padding(start = 33.dp, end = 33.dp, top = 33.dp)
            )
            OutlinedCard(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 33.dp, end = 33.dp, top = 10.dp),
                onClick = {
                    mExpanded = !mExpanded
                }

            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = mSelectedText, Modifier.padding(13.dp))
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(imageVector = icon, contentDescription = null)


                }
            }
            Box(modifier = Modifier.fillMaxWidth()) {
                DropdownMenu(
                    expanded = mExpanded,
                    onDismissRequest = { mExpanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 33.dp, end = 33.dp)
                ) {
                    availability.forEach { lable ->
                        DropdownMenuItem(
                            text = { Text(text = lable) },
                            onClick = {
                                mSelectedText = lable
                                mExpanded = false
                            })
                    }

                }
            }
            Text(
                text = "Add Your Status",
                style = TextStyle(
                    fontSize = 15.5.sp,
                    fontFamily = FontFamily(Font(R.font.inter_font)),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF405058),
                ),
                modifier = Modifier.padding(start = 33.dp, end = 33.dp, top = 10.dp)
            )
            OutlinedTextField(
                value = mTextFild,
                onValueChange = {
                    if (it.length <= 250) {
                        mTextFild = it
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 33.dp, end = 33.dp)
            )
            Box(modifier = Modifier.fillMaxWidth().padding(start = 33.dp, end = 33.dp)){
                Text(text = "${mTextFild.length}/250", modifier = Modifier.align(Alignment.TopEnd))

            }
            Text(
                text = "Select Hyper local Distance",
                style = TextStyle(
                    fontSize = 15.5.sp,
                    fontFamily = FontFamily(Font(R.font.inter_font)),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF405058),
                ),
                modifier = Modifier.padding(start = 33.dp, end = 33.dp)
            )
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 1f..100f,
                modifier = Modifier
                    .padding(end = 33.dp, start = 33.dp),
                colors = SliderDefaults.colors(
                    activeTrackColor = Color.Transparent, // Set active track color to transparent
                    inactiveTrackColor = Color.Transparent,
                    thumbColor = Color(0xFF143D58)
                ),
                thumb = { it ->
                    CustomCar(
                        modifier = Modifier, value = sliderPosition.toInt().toString()
                    )
                })
            Slider(
                value = sliderPosition,
                onValueChange = { sliderPosition = it },
                valueRange = 1f..100f,
                modifier = Modifier.padding(end = 33.dp, start = 33.dp),
                colors = SliderDefaults.colors(
                    activeTrackColor = Color(0xFF143D58),
                    thumbColor = Color(0xFF143D58)
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 33.dp, start = 33.dp)
            ) {
                Text(text = "1Km")
                Text(text = "100Km", Modifier.align(Alignment.TopEnd))
            }
            Text(
                text = "Select Purpose",
                style = TextStyle(
                    fontSize = 15.5.sp,
                    fontFamily = FontFamily(Font(R.font.inter_font)),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF405058),
                ),
                modifier = Modifier.padding(start = 33.dp, end = 33.dp, top = 10.dp)
            )
            Row(
                Modifier
                    .padding(start = 33.dp, end = 33.dp)
                    .fillMaxWidth()) {
                ClickableCard(text = "Coffe")
                ClickableCard(text = "Business")
                ClickableCard(text = "Hobbies")
                ClickableCard(text = "Friendship")
            }
            Row(
                Modifier
                    .padding(start = 33.dp, end = 33.dp)
                    .fillMaxWidth()) {
                ClickableCard(text = "Movie")
                ClickableCard(text = "Dining")
                ClickableCard(text = "Dating")
                ClickableCard(text = "Matrimony")
            }
            Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)){
                Button(onClick = { /*TODO*/ },colors = ButtonDefaults.buttonColors(Color(0xFF143D58))) {

                    Text(text = "Save & Explore")

                }
            }




        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableCard(
    text: String,
    modifier: Modifier = Modifier,
) {
    var active by remember { mutableStateOf(false) }
    var color by remember {
        mutableStateOf(Color.White)
    }
    var textcolor by remember {
        mutableStateOf(Color.Black)
    }

    OutlinedCard(onClick = {
        if (active) {
            color = Color.White
            textcolor=Color.Black
            active = !active

        } else {
            color = Color(0xFF405058)
            textcolor=Color.White
            active = !active
        }},
        modifier = modifier.padding(4.dp)
           ,
        colors = CardDefaults.cardColors(color)) {
        Text(text = text, color = textcolor, modifier = Modifier.padding(8.dp), fontSize = 14.sp)
    }
    }




