package edu.iesam.laligatracker.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.laligatracker.BuildConfig
import edu.iesam.laligatracker.features.clubs.data.local.db.ClubEntity
import edu.iesam.laligatracker.features.clubs.data.local.db.ClubsDao

@Database(entities = [ClubEntity::class], version = BuildConfig.VERSION_CODE, exportSchema = false)
abstract class LaLigaTrackerDataBase : RoomDatabase() {
    abstract fun clubsDao(): ClubsDao
}