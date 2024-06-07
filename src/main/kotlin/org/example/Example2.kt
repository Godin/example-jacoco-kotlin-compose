package org.example

import androidx.compose.runtime.*
import androidx.compose.desktop.ui.tooling.preview.Preview

@Retention(AnnotationRetention.RUNTIME)
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.CONSTRUCTOR
)
annotation class ExcludeGenerated

@Preview
@Composable
@ExcludeGenerated
fun LayoutPreview_NotExcluded() {
  println("Some")
}
