package com.example.uade.androidguideexercises.exercises.ex06

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 6 — Estado, botones y recomposición: contador
 *
 * Objetivos
 * Comprender qué significa "estado" en una interfaz declarativa.
 * Utilizar remember y estado mutable.
 * Responder a eventos onClick.
 * Observar la recomposición.
 *
 * Consigna
 * Crear un contador con:
 *      texto con el valor actual;
 *      botón +1;
 *      botón -1;
 *      botón Reiniciar.
 * El contador no puede ser menor que cero.
 */

@Composable
fun Exercise06(modifier: Modifier = Modifier) {
    Contador(modifier)
}

@Composable
fun Contador(modifier: Modifier = Modifier) {
    // Estado: Compose observa esta variable y redibuja lo que la use.
    var contador by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Valor: $contador",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { contador-- }, enabled = contador > 0) {
                Text(text = "-1")
            }
            Button(onClick = { contador++ }) {
                Text(text = "+1")
            }
        }

        Button(
            onClick = { contador = 0 },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Reiniciar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Exercise06Preview() {
    AndroidGuideExercisesTheme {
        Exercise06()
    }
}
