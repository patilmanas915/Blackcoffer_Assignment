package com.example.blackcoffer_assignment.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackcoffer_assignment.ui.theme.Blackcoffer_AssignmentTheme

@Composable
fun CustomCar(value: String = "50", modifier: Modifier) {
    Box(modifier = Modifier.size(30.dp)) {
        Card(
            shape = CutCornerShape(50.dp), modifier = Modifier
                .size(17.dp)
                .align(Alignment.BottomCenter), colors = CardDefaults.cardColors(Color(0xFF143D58))
        ) {

            Spacer(modifier = Modifier)
        }
        Card(
            shape = CutCornerShape(0),
            colors = CardDefaults.cardColors(Color(0xFF143D58)),
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp)
        ) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = value, color = Color.White)
            }

        }

    }

}




@Preview(showBackground = true)
@Composable
fun Greetin() {
    Blackcoffer_AssignmentTheme {
        CustomCar(modifier = Modifier)
    }
}