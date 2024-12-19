package meet.anayacoders.businesspostermaker.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import meet.anayacoders.businesspostermaker.data.database.remote.ApiService
import meet.anayacoders.businesspostermaker.data.repository.GeneralEventRepositoryImpl
import meet.anayacoders.businesspostermaker.data.repository.PosterRepositoryImpl
import meet.anayacoders.businesspostermaker.data.repository.UpcomingEventRepositoryImpl
import meet.anayacoders.businesspostermaker.domain.repository.GeneralEventRepository
import meet.anayacoders.businesspostermaker.domain.repository.PosterRepository
import meet.anayacoders.businesspostermaker.domain.repository.UpcomingEventRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePosterRepository(apiService: ApiService): PosterRepository =
        PosterRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideUpcomingEventRepository(apiService: ApiService): UpcomingEventRepository =
        UpcomingEventRepositoryImpl(apiService)

    @Provides
    @Singleton
    fun provideGeneralEventRepository(apiService: ApiService): GeneralEventRepository =
        GeneralEventRepositoryImpl(apiService)
}