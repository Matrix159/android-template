package com.matrix159.androidtemplate.core.network.di

import com.matrix159.androidtemplate.core.network.createHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
  @Provides
  @Singleton
  internal fun provideHttpClient(): HttpClient = createHttpClient()
}