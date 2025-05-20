package com.example.todoapp.repository

import com.example.todoapp.data.ToDo
import com.example.todoapp.data.ToDoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val dao: ToDoDao
) {
    fun getTodos(): Flow<List<ToDo>> = dao.getAll()
    suspend fun insert(todo: ToDo) = dao.insert(todo)
    suspend fun delete(todo: ToDo) = dao.delete(todo)
    suspend fun update(todo: ToDo) = dao.update(todo)
}
