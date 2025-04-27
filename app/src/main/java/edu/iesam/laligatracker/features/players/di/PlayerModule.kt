package edu.iesam.laligatracker.features.players.di

import edu.iesam.laligatracker.app.data.local.db.LaLigaTrackerDataBase
import edu.iesam.laligatracker.features.players.data.local.db.PlayersDao
import edu.iesam.laligatracker.features.players.data.remote.PlayerService
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit

@Module
@ComponentScan
class PlayerModule {
    @Single
    fun providePlayerService(retrofit: Retrofit): PlayerService {
        return retrofit.create(PlayerService::class.java)
    }

    @Single
    fun providePlayerDao(db: LaLigaTrackerDataBase): PlayersDao {
        return db.playersDao()
    }
}