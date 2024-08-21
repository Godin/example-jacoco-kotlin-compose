package org.example

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp

@Composable
fun Animation() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        var step by remember { mutableStateOf(0) }
        val scale: Float by animateFloatAsState(if (step > 0) 4f else 1f)
        val pos by animateDpAsState(if (step > 1) 100.dp else 0.dp)
        Text(
            """
                line 1
                line 2
                line 3
                line 4
                line 5
                line 6
                line 7
                line 8
                line 9
                line 10
                """.trimIndent(),
            modifier = Modifier
                .offset(x = 0.dp, y = pos)
                .scale(scale)
                .clickable {
                    step++
                }
        )
    }
}
