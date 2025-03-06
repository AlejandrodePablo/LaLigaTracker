package edu.iesam.laligatracker.app.di

import android.content.Context
import androidx.room.Room
import edu.iesam.laligatracker.app.LaLigaTrackerApp
import edu.iesam.laligatracker.app.data.local.db.LaLigaTrackerDataBase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDataBase(context: Context): LaLigaTrackerDataBase {
        val db = Room.databaseBuilder(
            context,
            LaLigaTrackerDataBase::class.java,
            "laliga-tracker-db"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }
}