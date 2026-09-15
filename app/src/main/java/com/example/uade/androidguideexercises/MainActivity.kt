package com.example.uade.androidguideexercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.exercises.ex01.Exercise01
import com.example.uade.androidguideexercises.exercises.ex02.Exercise02
import com.example.uade.androidguideexercises.exercises.ex03.Exercise03
import com.example.uade.androidguideexercises.exercises.ex04.Exercise04
import com.example.uade.androidguideexercises.exercises.ex05.Exercise05
import com.example.uade.androidguideexercises.exercises.ex06.Exercise06
import com.example.uade.androidguideexercises.exercises.ex07.Exercise07
import com.example.uade.androidguideexercises.exercises.ex08.Exercise08
import com.example.uade.androidguideexercises.exercises.ex09.Exercise09
import com.example.uade.androidguideexercises.exercises.ex10.Exercise10
import com.example.uade.androidguideexercises.exercises.ex11.Exercise11
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidGuideExercisesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GuiaDeEjercicios(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

/**
 * Indice de la guia. Guarda que ejercicio esta abierto: null = pantalla de menu.
 * Es un adelanto del Ejercicio 6 (estado y recomposicion); alcanza con saber que al
 * cambiar `ejercicioAbierto`, Compose vuelve a dibujar esta pantalla.
 */
@Composable
fun GuiaDeEjercicios(modifier: Modifier = Modifier) {
    var ejercicioAbierto by remember { mutableStateOf<Int?>(null) }

    when (ejercicioAbierto) {
        null -> MenuDeEjercicios(
            modifier = modifier,
            onSeleccionar = { numero -> ejercicioAbierto = numero }
        )

        1 -> PantallaDeEjercicio(
            titulo = "Ejercicio 1 - Primer proyecto",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise01()
        }

        2 -> PantallaDeEjercicio(
            titulo = "Ejercicio 2 - Composables y Preview",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise02()
        }

        3 -> PantallaDeEjercicio(
            titulo = "Ejercicio 3 - val, var y tipos",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise03()
        }

        4 -> PantallaDeEjercicio(
            titulo = "Ejercicio 4 - Funciones, parámetros y componentes reutilizables",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise04()
        }

        5 -> PantallaDeEjercicio(
            titulo = "Ejercicio 5 - Column, Row, Modifier y Material 3",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise05()
        }

        6 -> PantallaDeEjercicio(
            titulo = "Ejercicio 6 -  Estado, botones y recomposición: contador",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise06()
        }

        7 -> PantallaDeEjercicio(
            titulo = "Ejercicio 7 -  TextField, if/when y null safety",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise07()
        }

        8 -> PantallaDeEjercicio(
            titulo = "Ejercicio 8 — Calculadora pequeña, Logcat y debugger",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise08()
        }

        9 -> PantallaDeEjercicio(
            titulo = "Ejercicio 9 — Data class, List y LazyColumn",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise09()
        }

        10 -> PantallaDeEjercicio(
            titulo = "Ejercicio 10 — Lista editable: tareas del estudiante",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise10()
        }

        11 -> PantallaDeEjercicio(
            titulo = "Ejercicio 11 — Recursos Android y configuración visual",
            modifier = modifier,
            onVolver = { ejercicioAbierto = null }
        ) {
            Exercise11()
        }
    }
}

@Composable
fun MenuDeEjercicios(onSeleccionar: (Int) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Guia de ejercicios",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onSeleccionar(1) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("1 - Primer proyecto")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { onSeleccionar(2) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("2 - Composables y Preview")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { onSeleccionar(3) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("3 - val, var y tipos")
        }

        Button(
            onClick = { onSeleccionar(4) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("4 - Funciones, parámetros y componentes reutilizables")
        }

        Button(
            onClick = { onSeleccionar(5) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("5 - Column, Row, Modifier y Material 3")
        }

        Button(
            onClick = { onSeleccionar(6) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("6 - Estado, botones y recomposición: contador")
        }

        Button(
            onClick = { onSeleccionar(7) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("7 — TextField, if/when y null safety")
        }

        Button(
            onClick = { onSeleccionar(8) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("8 — Calculadora pequeña, Logcat y debugger")
        }

        Button(
            onClick = { onSeleccionar(9) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("9 — Data class, List y LazyColumn")
        }

        Button(
            onClick = { onSeleccionar(10) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("10 — Lista editable: tareas del estudiante")
        }

        Button(
            onClick = { onSeleccionar(11) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("11 — Recursos Android y configuración visual")
        }
    }
}

@Composable
fun PantallaDeEjercicio(
    titulo: String,
    onVolver: () -> Unit,
    modifier: Modifier = Modifier,
    contenido: @Composable () -> Unit
) {
    Column(modifier = modifier.padding(16.dp)) {
        TextButton(onClick = onVolver) {
            Text("< Volver")
        }
        Text(text = titulo, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        contenido()
    }
}

@Preview(showBackground = true)
@Composable
fun MenuDeEjerciciosPreview() {
    AndroidGuideExercisesTheme {
        MenuDeEjercicios(onSeleccionar = {})
    }
}
