package com.example.uade.androidguideexercises.exercises.ex07

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.exercises.ex08.Exercise08
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 07 —
 *
 * Objetivos
 * Leer datos ingresados por el usuario.
 * Usar TextField u OutlinedTextField.
 * Convertir texto a número mediante toIntOrNull().
 * Trabajar con null.
 * Aplicar condiciones con if o when.
 *
 * Consigna
 */

@Composable
fun Exercise07(modifier: Modifier = Modifier) {
    ClasificadorEdad();
}

@Preview(showBackground = true)
@Composable
fun Exercise07Preview() {
    AndroidGuideExercisesTheme {
        Exercise07()
    }
}

@Composable
fun ClasificadorEdad() {
    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(horizontal = 5.dp, 10.dp)
    ) {
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.padding(top = 10.dp)
        )
        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    resultado = evaluarEdad(edad)
                },
            ) {
                Text(text = "Evaluar")
            }
            Text(
                text = "Resultado: $resultado",
                Modifier.padding(start = 10.dp)
            )
        }

    }
}

fun evaluarEdad(edadTexto: String): String {
    val edadInt = edadTexto.toIntOrNull()
    if (edadInt == null || edadInt < 0) {
        return "Error: ingresá un número válido"
    }

    if (edadInt < 18) {
        return "Menor de edad"
    }
    return "Mayor de edad"
}