package com.example.fun_fact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.fun_fact.ui.theme.Fun_FactTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Fun_FactTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   ff()
                }
            }
        }
    }
}

@Composable
fun ff(){

    var facts = arrayOf( "Octopuses have three hearts and blue blood", "Honey never spoils and can be eaten indefinitely","A day on Venus is longer than a year on Venus","Bananas are berries but strawberries aren't","Wombat poop is cube-shaped to prevent it from rolling away","The Eiffel Tower can be 15 cm taller during the summer","A single strand of spaghetti is called a 'spaghetto","More human twins are born in Nigeria than anywhere else","The shortest war in history was between Britain and Zanzibar on August 27, 1896, lasting between 38 and 45 minutes.")
    var x by remember { mutableStateOf( Random.nextInt(0,facts.size-1)) }
    var text=facts[x]
    Button(onClick = {
        if (x == facts.size - 1){
            x=0
        }
        else{
            x += 1
        }

    }) {
        Text("JuicyQuote")
    }

    Column(modifier=Modifier.fillMaxHeight().wrapContentSize(Alignment.Center),horizontalAlignment= Alignment.CenterHorizontally,){
        Text(text = facts[x],
            fontSize = 30.sp)
    }


}
