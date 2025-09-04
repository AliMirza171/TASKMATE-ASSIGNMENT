package model

data class Task(
    val id: Long,
    val title: String,
    val description: String,
    val deadline: String,
    val completed: Boolean = false
)
