package com.example.weather.data.di

import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@OptIn(ExperimentalCoroutinesApi::class)
@Singleton
@Component(
    modules = [
        ApiModule::class,
        DispatcherModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent