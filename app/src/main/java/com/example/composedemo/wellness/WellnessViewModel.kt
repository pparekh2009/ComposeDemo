package com.example.composedemo.wellness

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()

    val tasks: List<WellnessTask>
        get() = _tasks

    fun removeTasks(item: WellnessTask) {
        _tasks.remove(item)
    }

    private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task #$i") }

    fun changeTaskChanged(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task -> {
            task.checked = checked
        } }

}