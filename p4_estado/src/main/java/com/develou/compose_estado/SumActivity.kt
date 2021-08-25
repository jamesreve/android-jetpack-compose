package com.develou.compose_estado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.develou.compose_estado.examples.SumScreenWithViewModel

class SumActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumScreenWithViewModel()
        }
    }
}

fun String?.toDoubleOrZero() = this?.toDoubleOrNull() ?: 0.0