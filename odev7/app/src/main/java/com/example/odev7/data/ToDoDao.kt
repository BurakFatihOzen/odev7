package com.example.todoapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todos")
    fun getAll(): Flow<List<ToDo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: ToDo)

    @Delete
    suspend fun delete(todo: ToDo)

    @Update
    suspend fun update(todo: ToDo)
}
