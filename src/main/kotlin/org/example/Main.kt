package org.example

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import kotlin.math.max
import kotlin.math.min

data class Slide(val content: @Composable () -> Unit)

val slides = listOf(
    Slide {
        Text("Slide 1")
    },
    Slide {
        Text("Slide 2")
    },
);

@Composable
fun presentation(currentSlideIndex: Int) {
    Box(
        Modifier
            .fillMaxSize()
    ) {
        slides.forEachIndexed { slideIndex, slide ->
            AnimatedVisibility(
                visible = slideIndex == currentSlideIndex,
            ) {
                slide.content()
            }
        }
    }
}

// TODO try compose for web
fun main() = application {
    var currentSlideIndex by remember { mutableStateOf(0) }
    Window(
        onCloseRequest = ::exitApplication,
        onKeyEvent = onKeyEvent@{ event ->
            if (event.type != KeyEventType.KeyDown) return@onKeyEvent false
            when (event.key) {
                Key.DirectionLeft -> currentSlideIndex = max(currentSlideIndex - 1, 0)
                Key.DirectionRight -> currentSlideIndex = min(currentSlideIndex + 1, slides.size - 1)
            }
            return@onKeyEvent true
        }
    ) {
        presentation(currentSlideIndex)
    }
}
