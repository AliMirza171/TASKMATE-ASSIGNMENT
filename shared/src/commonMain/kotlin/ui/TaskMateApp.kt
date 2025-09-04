package ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import model.Task

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskMateApp() {
    var tasks by remember { mutableStateOf(listOf<Task>()) }
    var newTitle by remember { mutableStateOf("") }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("TaskMate") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (newTitle.isNotBlank()) {
                    tasks = tasks + Task(
                        id = System.currentTimeMillis(),
                        title = newTitle,
                        description = "",
                        deadline = ""
                    )
                    newTitle = ""
                }
            }) { Text("+") }
        }
    ) { padding ->
        TaskListScreen(
            tasks = tasks,
            newTitle = newTitle,
            onTitleChange = { newTitle = it },
            onToggle = { id ->
                tasks = tasks.map {
                    if (it.id == id) it.copy(completed = !it.completed) else it
                }
            },
            modifier = androidx.compose.ui.Modifier.padding(padding)
        )
    }
}
