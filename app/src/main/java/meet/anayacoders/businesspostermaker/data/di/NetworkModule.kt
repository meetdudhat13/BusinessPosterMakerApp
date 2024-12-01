package meet.anayacoders.businesspostermaker.data.di

import androidx.annotation.RestrictTo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import meet.anayacoders.businesspostermaker.data.database.remote.PosterApiService
import meet.anayacoders.businesspostermaker.other.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providePosterApiService(retrofit: Retrofit): PosterApiService = retrofit.create(PosterApiService::class.java)

}