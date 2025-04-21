package edu.iesam.laligatracker.features.players.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface PlayersDao {

    @Transaction
    @Query("SELECT * FROM $PLAYERS_TABLE WHERE club_id = :clubId")
    suspend fun findAllPlayers(clubId: String): List<PlayerWithStats>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllPlayers(vararg playersEntity: PlayersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllStats(vararg statsEntity: StatsEntity)
}