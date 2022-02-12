package com.develou.compose_temas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.develou.compose_temas.theme.ProductsTheme

class ProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTheme {
                Surface {
                    Products()
                }
            }
        }
    }
}