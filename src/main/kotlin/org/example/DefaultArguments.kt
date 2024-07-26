package org.example

import androidx.compose.runtime.*

@Composable
fun default_arguments(i: Int = 2) {
  if (i < 0)
    return
  default_arguments(i - 1)
}
