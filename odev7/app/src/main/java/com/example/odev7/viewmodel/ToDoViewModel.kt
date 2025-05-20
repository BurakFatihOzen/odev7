package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.ToDo
import com.example.todoapp.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repo: ToDoRepository
) : ViewModel() {
    val todos = repo.getTodos().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun insert(todo: ToDo) = viewModelScope.launch {
        repo.insert(todo)
    }

    fun delete(todo: ToDo) = viewModelScope.launch {
        repo.delete(todo)
    }
}
