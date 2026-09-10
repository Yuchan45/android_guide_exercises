package com.example.uade.androidguideexercises.exercises.ex02

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 2 - Primeros pasos con funciones @Composable.
 *
 * Presentacion() se usa desde dos lugares distintos: desde la pantalla de la app
 * (a traves de Exercise02, que MainActivity invoca) y desde PresentacionPreview().
 *
 * Experimentacion pedida por la consigna (probar una por vez y volver atras):
 *  1. Sacar @Composable -> el compilador rechaza la llamada a Text(): "@Composable
 *     invocations can only happen from the context of a @Composable function". Text()
 *     necesita el Composer que la anotacion inyecta en la funcion.
 *  2. Escribir mal Text (por ejemplo "Txt") -> "Unresolved reference": el nombre no existe
 *     y ademas no se agrega el import automatico.
 *  3. Poner dos Text() sin layout -> compilan, pero se dibujan uno encima del otro en la
 *     esquina superior izquierda: sin un contenedor nadie decide como ubicarlos. Por eso
 *     aca se usa Column, que los apila verticalmente.
 */
@Composable
fun Presentacion(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Nombre: Yu Nakasone",
            style = MaterialTheme.typography.titleMedium
        )
        Text(text = "Carrera: Ingenieria en Informatica")
        Text(text = "Tecnologia que quiero aprender: Jetpack Compose")
    }
}

@Composable
fun Exercise02(modifier: Modifier = Modifier) {
    Presentacion(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun PresentacionPreview() {
    AndroidGuideExercisesTheme {
        Presentacion()
    }
}
