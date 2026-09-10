package com.example.uade.androidguideexercises.exercises.ex01

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
 * Ejercicio 1 - Primer proyecto, emulador y recorrido del entorno.
 *
 * Recorrido del entorno (puntos 1 a 8 de la consigna):
 *  - MainActivity.kt ......... app/src/main/java/com/example/uade/androidguideexercises/
 *  - AndroidManifest.xml ..... app/src/main/AndroidManifest.xml
 *  - Gradle del modulo app ... app/build.gradle.kts
 *  - Device Manager .......... barra lateral derecha de Android Studio, para crear el AVD.
 *  - La compilacion se ve en la ventana Build (parte inferior); la ejecucion, en Run/Logcat.
 *
 * Respuestas a las preguntas:
 *  1. El codigo Kotlin principal esta en MainActivity.kt: es la Activity que Android lanza
 *     al abrir la app y la que llama a setContent { ... } para dibujar la interfaz.
 *  2. Run compila la app, la instala y la ejecuta en el AVD (proceso real, con ciclo de vida
 *     y acceso al sistema). El Preview solo renderiza un composable dentro del IDE: es un
 *     dibujo estatico, no ejecuta la app ni necesita emulador.
 *  3. Un AVD (Android Virtual Device) es la *definicion* del dispositivo virtual: modelo,
 *     imagen del sistema, API, RAM, resolucion. El emulador es el *programa* que ejecuta esa
 *     definicion. No son lo mismo: un mismo emulador puede correr distintos AVD.
 *  4. La del AVD creado en Device Manager. Este proyecto compila contra API 37 y admite
 *     desde minSdk 24 (ver app/build.gradle.kts), asi que el AVD debe tener API >= 24.
 *  5. No falla: Android Studio arranca el AVD automaticamente y espera a que termine de
 *     bootear antes de instalar la app. Solo tarda mas la primera ejecucion.
 */
@Composable
fun Exercise01(modifier: Modifier = Modifier) {
    // TODO: reemplazar por el nombre del estudiante.
    val nombreEstudiante = "Yu Nakasone"

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Hola Android - $nombreEstudiante",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Exercise01Preview() {
    AndroidGuideExercisesTheme {
        Exercise01()
    }
}
