package com.matrix159.androidtemplate.core.database.di

import android.content.Context
import androidx.room.Room
import com.matrix159.androidtemplate.core.database.AppDatabase
import com.matrix159.androidtemplate.core.database.dao.ExampleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
  @Provides
  @Singleton
  internal fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
    return Room.databaseBuilder(
      appContext,
      AppDatabase::class.java,
      "androidtemplate-database"
    ).build()
  }

  @Provides
  internal fun provideExampleDao(database: AppDatabase): ExampleDao {
    return database.exampleDao()
  }
}