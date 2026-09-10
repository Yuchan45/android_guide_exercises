package com.example.uade.androidguideexercises.exercises.ex04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Objetivos
 * Declarar funciones con parámetros.
 * Comprender argumentos y tipos de retorno.
 * Crear composables reutilizables.
 * Evitar duplicación simple de código.
 *
 */
@Composable
fun Exercise04(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(10.dp, 5.dp)) {
        DatoEstudiante("Nombre", "Yu");
        DatoEstudiante("Carrera", "Sistemas");
        DatoEstudiante("Anio", "3");
    }
}

@Preview(showBackground = true)
@Composable
fun Exercise04Preview(modifier: Modifier = Modifier) {
//    var response = descripcionEdad(18);

    Column(modifier = Modifier.padding(10.dp, 5.dp)) {
        DatoEstudiante("Nombre", "Yu");
        DatoEstudiante("Carrera", "Sistemas");
        DatoEstudiante("Anio", "3");
//        Text(
//            text = response
//        )
    }
}


@Composable
fun DatoEstudiante(etiqueta: String, valor: String) {
    Text(
        text = "$etiqueta: $valor"
    )

}

@Preview(showBackground = true)
@Composable
fun DatoEstudiantePreview() {
    AndroidGuideExercisesTheme {

        Column(modifier = Modifier.padding(10.dp, 5.dp)) {
            DatoEstudiante("Nombre", "Yu");
            DatoEstudiante("Carrera", "Sistemas");
            DatoEstudiante("Anio", "3");
        }
    }
}

fun descripcionEdad(edad: Int): String {
    if (edad >= 18) {
        return "Edad: $edad anios. (Mayor de edad)";
    }
    return "Edad: $edad anios. (Menor de edad)";
}