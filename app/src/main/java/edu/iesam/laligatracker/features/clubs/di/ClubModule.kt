package edu.iesam.laligatracker.features.clubs.di

import edu.iesam.laligatracker.app.data.local.db.LaLigaTrackerDataBase
import edu.iesam.laligatracker.features.clubs.data.local.db.ClubsDao
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

    @Single
    fun provideClubsDao(db: LaLigaTrackerDataBase): ClubsDao {
        return db.clubsDao()
    }
}