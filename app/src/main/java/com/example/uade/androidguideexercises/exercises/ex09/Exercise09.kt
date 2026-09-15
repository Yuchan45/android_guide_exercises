package com.example.uade.androidguideexercises.exercises.ex09

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 09 —
 *
 * Objetivos
 * Introducir clases de datos en Kotlin.
 * Crear y recorrer una colección.
 * Mostrar listas con LazyColumn.
 * Diferenciar los datos de su representación visual.
 *
 * Consigna
 */

@Composable
fun Exercise09() {
    val materias = listOf(
        Materia("Algoritmos I", 1, true),
        Materia("Analisis Mat. II", 1, true),
        Materia("Algebra II", 1, false),
        Materia("Org. del Computador", 1, true),
        Materia("Sistemas Operativos", 1, true),
        Materia("Estructura de datos", 1, false),
        Materia("Probabilidad", 1, true),
        Materia("Estadistica", 1, false),
        Materia("Estadistica II", 2, false),
        Materia("Patrones y Arquitecturas", 2, true),
        Materia("Testing", 1, false),
        Materia("asd", 1, true),
        Materia("asd2", 1, false),
        Materia("asd II", 2, false),
        Materia("fasfasf", 2, true),
        Materia("asdasdasd", 2, false),
    )

    Column {
        Text("Total: ${materias.size}")
        LazyColumn {
            items(materias) { materia ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = materia.nombre)
                        Text(text = "Año: ${materia.anio}")
                    }
                    Text(
                        text = if (materia.aprobada) "Aprobada" else "Pendiente",
                        color = if (materia.aprobada) Color.Green else Color.Red
                    )
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun Exercise09Preview() {
    AndroidGuideExercisesTheme {
        Exercise09()
    }
}

data class Materia(
    val nombre: String,
    val anio: Int,
    val aprobada: Boolean
)