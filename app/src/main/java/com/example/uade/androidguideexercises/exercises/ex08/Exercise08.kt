package com.example.uade.androidguideexercises.exercises.ex08

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.exercises.ex07.evaluarEdad
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 08 — Calculadora
 *
 * Objetivos
 * - Calculadora
 * - Debug
 * - Logcat
 *
 * Consigna
 */

@Composable
fun Exercise08(modifier: Modifier = Modifier) {
    var val1 by remember { mutableStateOf("") }
    var val2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    Log.d("CALCULADORA", "info")

    Column(
        modifier = Modifier.padding(horizontal = 5.dp, 10.dp)
    ) {
        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = val1,
                onValueChange = { val1 = it },
                label = { Text("Valor 1") },
                modifier = Modifier.weight(1f)

            )
            TextField(
                value = val2,
                onValueChange = { val2 = it },
                label = { Text("Valor 2") },
                modifier = Modifier.weight(1f)
            )
        }

        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    resultado = evaluarYCalcular(val1, val2, '+')
                },
            ) {
                Text(text = "+")
            }
            Button(
                onClick = {
                    resultado = evaluarYCalcular(val1, val2, '-')
                },
            ) {
                Text(text = "-")
            }
            Button(
                onClick = {
                    resultado = evaluarYCalcular(val1, val2, 'X')
                },
            ) {
                Text(text = "X")
            }
        }
        Text(
            text = "Resultado: $resultado",
            Modifier.padding(start = 10.dp)
        )

    }
}

@Preview(showBackground = true)
@Composable
fun Exercise08Preview() {
    AndroidGuideExercisesTheme {
        Exercise08()
    }
}


fun evaluarYCalcular(val1Texto: String, val2Texto: String, operacion: Char): String {
    val value1 = val1Texto.toDoubleOrNull()
    val value2 = val2Texto.toDoubleOrNull()

    if (value1 == null || value2 == null) {
        return "Error: ingresá números válidos"
    }

    return calcular(value1, value2, operacion).toString()
}

fun calcular(val1: Double, val2: Double, operacion: Char): Double {
    return when (operacion) {
        '+' -> val1 + val2
        '-' -> val1 - val2
        else -> val1 * val2
    }
}