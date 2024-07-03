package com.lucas.waterbottle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.waterbottel.WatterBottle
import com.lucas.waterbottle.ui.theme.WaterBottleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterBottleTheme {
            Surface (modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background){
                var usedAmount = remember { mutableStateOf(50) }
                var totalWaterAmount = remember { mutableStateOf(2500)}
                Column (modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center){
                    WatterBottle(
                        totalWaterAmount = totalWaterAmount.value,
                        unit = "ml",
                        usedWaterAmount = usedAmount.value,
                        modifier = Modifier)
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(text = "Total Amount is: ${totalWaterAmount.value}")
                    Button(onClick = {usedAmount.value += 200}) {
                        Text(text = "Drink")
                    }
                }
            }
            }
        }
    }
}