package com.develou.compose_componentes.examples.Menu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.develou.compose_componentes.examples.Example
import com.develou.compose_componentes.examples.ExampleScreen
import com.develou.compose_componentes.examples.RadioButton.SurfaceForPreview

@Composable
fun MenusScreen() {
    val examples = listOf(
        Example("1. Dropdown Menu Simple") { TasksUi() },
        Example("2. Dropdown Menu Items Personalizados") { ImageUi() },
        Example("3. Dropdown Menu Temificado") { ThemedTaskMenu() },
        Example("4. Exposed Dropdown Menu Simple") { PhoneNumberTypeMenu() },
    )
    ExampleScreen(
        tutorialTitle = "Menus En Compose",
        examples = examples
    )
}

@Preview
@Composable
fun MenusScreenPreview() {
    SurfaceForPreview(
        modifier = Modifier.fillMaxSize()
    ) {

        MenusScreen()
    }
}