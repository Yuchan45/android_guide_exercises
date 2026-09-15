package com.example.uade.androidguideexercises.exercises.ex11

import android.content.res.Configuration
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uade.androidguideexercises.R
import com.example.uade.androidguideexercises.ui.theme.AndroidGuideExercisesTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Ejercicio 11 — Recursos Android y configuración visual
 *
 * Objetivos
 * Comprender que no todo debe escribirse directamente en Kotlin.
 * Utilizar recursos de texto.
 * Acceder a recursos desde Compose.
 * Explorar tema claro/oscuro y Preview.
 *
 * Consigna
 * Tomar uno de los proyectos anteriores y mover los textos importantes a recursos de Android
 * (res/values/strings.xml), y luego utilizarlos desde Compose con stringResource.
 * Crear al menos dos previews: uno en configuración normal y otro en modo oscuro o con otra
 * configuración visual disponible.
 *
 * Esta pantalla es el Ejercicio 10 (lista de tareas) refactorizado:
 *  - los textos salen de res/values/strings_ex11.xml (y su traducción en res/values-en/);
 *  - los colores salen de MaterialTheme.colorScheme en vez de estar escritos a mano.
 *
 * Nota sobre dónde viven los recursos: tienen que estar bajo el source set del módulo
 * (app/src/main/res). Una carpeta res/ dentro del paquete ex11 quedaría en el árbol de código
 * Kotlin, AAPT2 no la procesaría y no se generaría R.string.*. Lo que sí se puede es separar
 * en varios archivos dentro de res/values/: todos se fusionan.
 */

@Composable
fun Exercise11(modifier: Modifier = Modifier) {
    // stringResource solo se puede llamar desde un @Composable, y la lambda de remember { }
    // no lo es: por eso los textos de la semilla se resuelven acá afuera.
    val semilla = listOf(
        Task(
            stringResource(R.string.ex11_tarea1_nombre),
            stringResource(R.string.ex11_tarea1_desc),
            Date()
        ),
        Task(
            stringResource(R.string.ex11_tarea2_nombre),
            stringResource(R.string.ex11_tarea2_desc),
            Date()
        ),
        Task(
            stringResource(R.string.ex11_tarea3_nombre),
            stringResource(R.string.ex11_tarea3_desc),
            Date()
        )
    )
    val tasks = remember { semilla.toMutableStateList() }

    var newTaskTitle by remember { mutableStateOf("") }
    var newTaskDescription by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.ex11_titulo),
            style = MaterialTheme.typography.titleMedium
        )

        LazyColumn {
            items(tasks) { task ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = task.nombre)
                        Text(text = formatearFecha(task.created_date))
                    }
                    Text(
                        text = task.descripcion,
                        modifier = Modifier.weight(1.5f),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    // El color ya no va escrito a mano: el tema tiene un rol semantico
                    // para acciones destructivas, y se adapta solo a claro/oscuro.
                    Button(
                        onClick = { tasks.remove(task) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error,
                            contentColor = MaterialTheme.colorScheme.onError
                        )
                    ) {
                        Text(text = stringResource(R.string.ex11_quitar))
                    }
                }
                HorizontalDivider()
            }
        }

        // Alta de tareas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            TextField(
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                label = { Text(stringResource(R.string.ex11_label_nombre)) },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = newTaskDescription,
                onValueChange = { newTaskDescription = it },
                label = { Text(stringResource(R.string.ex11_label_descripcion)) },
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth(),
                minLines = 4
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.End)
            ) {
                Button(
                    onClick = {
                        tasks.add(Task(newTaskTitle, newTaskDescription, Date()))
                        newTaskTitle = ""
                        newTaskDescription = ""
                    },
                    // La consigna pide no agregar cadenas vacias.
                    enabled = newTaskTitle.isNotBlank()
                ) {
                    Text(text = stringResource(R.string.ex11_agregar))
                }
            }
        }
    }
}

/**
 * Los tres previews. Van con dynamicColor = false a propósito: AndroidGuideExercisesTheme usa
 * color dinámico por defecto y en API 31+ eso reemplaza la paleta del tema por la del wallpaper,
 * con lo cual el preview oscuro se vería casi igual al claro.
 */
@Preview(name = "Claro", showBackground = true)
@Composable
fun Exercise11PreviewClaro() {
    AndroidGuideExercisesTheme(darkTheme = false, dynamicColor = false) {
        Exercise11()
    }
}

@Preview(
    name = "Oscuro",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun Exercise11PreviewOscuro() {
    AndroidGuideExercisesTheme(darkTheme = true, dynamicColor = false) {
        Exercise11()
    }
}

/** Misma pantalla leyendo res/values-en/, sin cambiar el idioma del dispositivo. */
@Preview(name = "Ingles", showBackground = true, locale = "en")
@Composable
fun Exercise11PreviewIngles() {
    AndroidGuideExercisesTheme(darkTheme = false, dynamicColor = false) {
        Exercise11()
    }
}

data class Task(
    val nombre: String,
    val descripcion: String,
    val created_date: Date
)

fun formatearFecha(fecha: Date): String {
    val formato = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    return formato.format(fecha)
}
