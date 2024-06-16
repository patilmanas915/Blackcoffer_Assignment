package com.example.blackcoffer_assignment.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackcoffer_assignment.ui.theme.Blackcoffer_AssignmentTheme

@Composable
fun CustomUserCard(modifier: Modifier,name:String="FirstName LastName") {
    Box(modifier = Modifier.size(400.dp,180.dp)){
        OutlinedCard(modifier= Modifier
            .align(Alignment.CenterEnd)
            .fillMaxSize()
            .padding(start = 60.dp, top = 10.dp)) {
            Column(modifier = Modifier.padding(start = 55.dp, top = 12.dp)) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(text = name, modifier = Modifier.align(Alignment.CenterStart))
                    Text(text = "+INVITE", modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 10.dp))
                }
                Text(text = "City|Job Role", fontSize = 14.sp, modifier = Modifier.padding(top = 6.dp))
                Text(text = "Within Distance", fontSize = 10.sp, modifier = Modifier.padding(top = 6.dp))
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 6.dp)) {
                    LinearProgressIndicator(progress = 0.3f, modifier = Modifier.width(48.dp))
                    Text(text = "Profile Scroe -100%", fontSize = 8.sp, modifier = Modifier.padding(8.dp))

                }


            }
            Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
                Text(text = "Coffee | Business |Friendship", fontSize = 14.sp)
                Text(text = "Hi community! I am open to new connection", fontSize = 14.sp)

            }

        }
        Card(modifier = modifier
            .align(Alignment.TopStart)
            .size(100.dp)) {
            Image(imageVector = Icons.Default.AccountBox, contentDescription =null,Modifier.fillMaxSize() )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Greview() {
    Blackcoffer_AssignmentTheme {
        CustomUserCard(modifier = Modifier)
    }
}