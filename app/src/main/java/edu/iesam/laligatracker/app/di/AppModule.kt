package edu.iesam.laligatracker.app.di

import com.google.gson.Gson
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("edu.iesam.laligatracker")
class AppModule {
    @Single
    fun provideGson() = Gson()
}