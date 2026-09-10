package com.example.uade.androidguideexercises.exercises.ex03

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 3 - Kotlin: val, var, tipos y plantillas de String.
 *
 * Respuestas a las preguntas:
 *  1. val se usa cuando el valor no se reasigna despues de inicializarlo. Es el caso por
 *     defecto: hace el codigo mas facil de seguir porque no hay que buscar reasignaciones.
 *  2. var es necesario cuando la misma referencia tiene que apuntar a otro valor mas
 *     adelante (un acumulador, un contador). En Compose, ademas, un var comun no alcanza
 *     para redibujar la pantalla: eso se resuelve con estado (mutableStateOf), en el Ej. 6.
 *  3. Que Kotlin deduce el tipo a partir del valor de inicializacion, sin que uno lo
 *     escriba. `val edad = 20` es exactamente `val edad: Int = 20`; el tipo existe y es
 *     fijo, solo que no hace falta declararlo. No es tipado dinamico.
 *  4. 20 es un Int (un numero, sirve para operar: edad + 1). "20" es un String (una
 *     secuencia de caracteres); "20" + 1 no suma, concatena y da "201". Tienen tipos
 *     distintos, ocupan memoria distinta y aceptan operaciones distintas.
 */
@Composable
fun FichaEstudiante(modifier: Modifier = Modifier) {
    // Parte A - tipos inferidos por Kotlin.
    val nombre = "Ana"                  // String
    val edad = 20                       // Int
    val promedio = 8.25                 // Double
    val cursaProgramacion = true        // Boolean

    // Variable adicional calculada a partir de otra.
    val anioProximo = edad + 1

    // Parte B - los mismos tipos, pero declarados explicitamente.
    val materias: Int = 5
    val ciudad: String = "Cordoba"

    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Ficha del estudiante",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text("Nombre: $nombre")
        Text("Edad: $edad")
        Text("Promedio: $promedio")
        Text("Cursa Programacion: $cursaProgramacion")
        Text("Materias: $materias")
        Text("Ciudad: $ciudad")

        Spacer(modifier = Modifier.height(12.dp))

        // Plantilla de String que combina texto y una expresion con ${...}.
        Text("El anio que viene $nombre va a cumplir $anioProximo anios.")
        Text("Le faltan ${materias - 1} materias despues de aprobar la proxima.")
    }
}

@Composable
fun Exercise03(modifier: Modifier = Modifier) {
    FichaEstudiante(modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun FichaEstudiantePreview() {
    AndroidGuideExercisesTheme {
        FichaEstudiante()
    }
}
