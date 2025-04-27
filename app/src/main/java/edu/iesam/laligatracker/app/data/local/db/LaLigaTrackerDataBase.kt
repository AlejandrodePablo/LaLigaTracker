package edu.iesam.laligatracker.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.laligatracker.BuildConfig
import edu.iesam.laligatracker.features.clubs.data.local.db.ClubEntity
import edu.iesam.laligatracker.features.clubs.data.local.db.ClubsDao
import edu.iesam.laligatracker.features.players.data.local.db.PlayersDao
import edu.iesam.laligatracker.features.players.data.local.db.PlayersEntity
import edu.iesam.laligatracker.features.players.data.local.db.StatsEntity

@Database(
    entities = [ClubEntity::class, PlayersEntity::class, StatsEntity::class],
    version = 3,
    exportSchema = false
)
abstract class LaLigaTrackerDataBase : RoomDatabase() {
    abstract fun clubsDao(): ClubsDao
    abstract fun playersDao(): PlayersDao
}