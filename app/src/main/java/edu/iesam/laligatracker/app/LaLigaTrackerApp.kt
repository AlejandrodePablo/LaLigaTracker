package edu.iesam.laligatracker.app

import android.app.Application
import edu.iesam.laligatracker.app.di.AppModule
import edu.iesam.laligatracker.app.di.LocalModule
import edu.iesam.laligatracker.app.di.RemoteModule
import edu.iesam.laligatracker.features.clubs.di.ClubModule
import edu.iesam.laligatracker.features.players.di.PlayerModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.ksp.generated.module

class LaLigaTrackerApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LaLigaTrackerApp)
            modules(
                AppModule().module,
                LocalModule().module,
                RemoteModule().module,
                ClubModule().module,
                PlayerModule().module
            )
        }
    }
}