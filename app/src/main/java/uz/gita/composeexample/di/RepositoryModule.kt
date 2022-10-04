package uz.gita.composeexample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.composeexample.data.repository.TestRepository
import uz.gita.composeexample.data.repository.impl.TestRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindTestRepository(impl: TestRepositoryImpl): TestRepository
}