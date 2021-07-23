package com.codinginflow.mvvmtodo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Query("SELECT * FROM task_table")
    fun getTasks(): Flow<List<Task>> // Flow is async stream of data

    //suspend function gets function to switch to different thread
    @Insert(onConflict = OnConflictStrategy.REPLACE) //what it should do if we try to insert a task with same id as another task
    suspend fun  insert(task: Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)
}