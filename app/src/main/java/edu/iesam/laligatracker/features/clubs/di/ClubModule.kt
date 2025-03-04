package edu.iesam.laligatracker.features.clubs.di

import edu.iesam.laligatracker.features.clubs.data.remote.ClubService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class ClubModule {
    @Single
    fun provideClubService(retrofit: Retrofit): ClubService =
        retrofit.create(ClubService::class.java)
}