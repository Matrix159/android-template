package com.matrix159.androidtemplate.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.matrix159.androidtemplate.core.database.dao.ExampleDao
import com.matrix159.androidtemplate.core.database.entity.ExampleEntity

@Database(
  entities = [
    ExampleEntity::class,
  ],
  version = 1,
  autoMigrations = []
)
abstract class AppDatabase : RoomDatabase() {
  abstract fun exampleDao(): ExampleDao
}
