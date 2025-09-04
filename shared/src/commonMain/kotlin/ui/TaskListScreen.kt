package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import model.Task

@Composable
fun TaskListScreen(
    tasks: List<Task>,
    newTitle: String,
    onTitleChange: (String) -> Unit,
    onToggle: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = newTitle,
            onValueChange = onTitleChange,
            label = { Text("New Task") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        tasks.forEach { task ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Checkbox(
                    checked = task.completed,
                    onCheckedChange = { onToggle(task.id) }
                )
                Text(task.title)
            }
        }
    }
}
