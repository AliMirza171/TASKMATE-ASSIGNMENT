import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ui.TaskMateApp

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "TaskMate Desktop") {
        TaskMateApp()
    }
}
