package com.example.uade.androidguideexercises.exercises.ex05

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme

/**
 * Ejercicio 5 — Column, Row, Modifier y Material 3
 * Objetivos
 * Organizar componentes con Column y Row.
 * Introducir Modifier.
 * Utilizar padding, fillMaxWidth y Arrangement.
 * Explorar componentes de Material 3
 *
 * Consigna
 * Rediseñar la ficha de los ejercicios anteriores para que tenga:
 *      un título;
 *      datos organizados verticalmente;
 *      al menos una fila con dos elementos;
 *      espaciado exterior mediante padding;
 *      un Button todavía sin comportamiento relevante
 */

@Composable
fun Exercise05() {
    FichaEstudiante("Tomas Yu Nakasone", "Lic. Sistemas", 3, "Licenciatura en Gestion de Tecnologias de la Informacion");
}

@Preview(showBackground = true)
@Composable
fun Exercise05Preview() {
    AndroidGuideExercisesTheme {
        FichaEstudiante("Tomas Yu Nakasone", "Lic. Sistemas", 3, "Licenciatura en Gestion de Tecnologias de la Informacion");
    }
}


@Composable
fun FichaEstudiante(nombre: String, carrera: String, anio: Int, desc: String) {

    Column() {
        Text(
            text = nombre,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.padding(top = 15.dp)
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Carrera: ")
                    }
                    withStyle(style = SpanStyle(fontSize = 14.sp)) {
                        append(carrera)
                    }
                },
                modifier = Modifier.weight(1f),
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append("Anio: ")
                    }
                    withStyle(style = SpanStyle(fontSize = 14.sp)) {
                        append(anio.toString())
                    }
                },
                modifier = Modifier.weight(1f)
            )
        }
        Column(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(
                text = "Descripcion:",
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = desc,
                fontSize = 14.sp
            )
        }

        Button(
            onClick = {
                //
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(150.dp)
                .padding(top = 15.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE)
            ),
        ) {
            Text(
                text = "Boton",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }

}


