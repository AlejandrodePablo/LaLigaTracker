package edu.iesam.laligatracker.features.players.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayersDao {

    @Query("SELECT * FROM $PLAYERS_TABLE")
    suspend fun findAllPlayers(): List<PlayersEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPlayers(vararg playersEntity: PlayersEntity)
}