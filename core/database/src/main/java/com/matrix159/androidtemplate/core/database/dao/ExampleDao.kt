package com.matrix159.androidtemplate.core.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.matrix159.androidtemplate.core.database.entity.ExampleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExampleDao {

  @Insert
  suspend fun insert(entity: ExampleEntity)

  @Update
  suspend fun update(entity: ExampleEntity)

  @Delete
  suspend fun delete(entity: ExampleEntity)

  @Query("SELECT * FROM example")
  fun getAll(): Flow<List<ExampleEntity>>

  @Query("SELECT * FROM example WHERE id = :id")
  suspend fun getById(id: Long): ExampleEntity?
}
