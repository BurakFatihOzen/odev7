package com.example.todoapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todoapp.viewmodel.ToDoViewModel
import com.example.todoapp.data.ToDo

@Composable
fun HomeScreen(viewModel: ToDoViewModel = hiltViewModel()) {
    val todos by viewModel.todos.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        todos.forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { viewModel.delete(it) },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(it.title)
                Checkbox(checked = it.isDone, onCheckedChange = null)
            }
        }

        var text by remember { mutableStateOf("") }
        Row {
            TextField(value = text, onValueChange = { text = it })
            Button(onClick = {
                viewModel.insert(ToDo(title = text))
                text = ""
            }) {
                Text("Ekle")
            }
        }
    }
}
