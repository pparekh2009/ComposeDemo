package com.example.composedemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp), onClick = { startActivity(Intent(this@MainActivity, ListActivity::class.java)) }) {
                    Text(text = "List")
                }
                Button(modifier = Modifier.padding(horizontal = 0.dp, vertical = 10.dp), onClick = { startActivity(Intent(this@MainActivity, MySootheActivity::class.java)) }) {
                    Text(text = "MySoothe")
                }
            }
        }
    }
}