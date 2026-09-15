package com.example.uade.androidguideexercises.exercises.ex10

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Ejercicio 10 —
 *
 * Objetivos
 * Manejar el estado de una colección.
 * Agregar y quitar elementos.
 * Combinar TextField, botones y LazyColumn.
 * Empezar a pensar la UI como función del estado
 *
 * Consigna
 */

@Composable
fun Exercise10(modifier: Modifier = Modifier) {
    Log.d("EX10", "Init")
    val tasks = remember { mutableStateListOf(
        Task("Comprar víveres", "Ir al supermercado y comprar frutas, verduras y lácteos", Date()),
        Task("Terminar informe", "Redactar el informe final del proyecto de la facultad", Date()),
        Task("Llamar al dentista", "Confirmar el turno de la próxima semana", Date())
    ) }
    var newTaskTitle by remember { mutableStateOf("") }
    var newTaskDescription by remember { mutableStateOf("") }

    Column {
        Text("Lista de Tareas")

        LazyColumn() {
            items(tasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = task.nombre,
                        )
                        Text(
                            text = formatearFecha(task.created_date),
                        )
                    }
                    Text(
                        text = task.descripcion,
                        modifier = Modifier.weight(1.5f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Button(
                        onClick = { tasks.remove(task) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFC62828),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Quitar")
                    }
                }
                HorizontalDivider()
            }
        }

        // Add/Remove module
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                // .align(Alignment.CenterHorizontally)

        ) {
            TextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = newTaskDescription,
                onValueChange = { newTaskDescription = it },
                label = { Text("Description") },
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
                ,
                minLines = 4
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.End),

            ) {
                Button(
                    onClick = {
                        val newTask = Task(newTaskTitle, newTaskDescription, Date())
                        tasks.add(newTask)
                        newTaskTitle = ""
                        newTaskDescription = ""
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2E7D32),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Agregar")
                }

            }
        }


    }

}

class Icons(
    imageVector: Any,
    contentDescription: String,
    tint: Color
) {
    class Default(imageVector: Any, contentDescription: String, tint: Color) {

    }

}

@Preview(showBackground = true)
@Composable
fun Exercise10Preview() {
    AndroidGuideExercisesTheme {
        Exercise10()
    }
}

data class Task (
    val nombre: String,
    val descripcion: String,
    val created_date: Date
)

fun formatearFecha(fecha: Date): String {
    val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return formato.format(fecha)
}
