package meet.anayacoders.businesspostermaker.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import meet.anayacoders.businesspostermaker.data.database.remote.PosterApiService
import meet.anayacoders.businesspostermaker.data.repository.PosterRepositoryImpl
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePosterRepository(apiService: PosterApiService): PosterRepository =
        PosterRepositoryImpl(apiService)
}