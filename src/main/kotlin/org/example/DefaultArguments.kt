package org.example

import androidx.compose.runtime.*

/**
 * https://github.com/JetBrains/kotlin/blob/2.1.0/plugins/compose/compiler-hosted/src/main/java/androidx/compose/compiler/plugins/kotlin/lower/ComposableFunctionBodyTransformer.kt#L3018-L3022
 * https://github.com/JetBrains/kotlin/blob/2.1.0/plugins/compose/compiler-hosted/src/main/java/androidx/compose/compiler/plugins/kotlin/lower/ComposableFunctionBodyTransformer.kt#L1364-L1407
 */
@Composable
fun default_arguments_example(
  a: String = "a",
  b: String = "b",
) {
}

fun non_composable_example(
  a: String = "a",
  b: String = "b",
) {
}

@Composable
fun default_arguments() {
  default_arguments_example()
  non_composable_example()
}
