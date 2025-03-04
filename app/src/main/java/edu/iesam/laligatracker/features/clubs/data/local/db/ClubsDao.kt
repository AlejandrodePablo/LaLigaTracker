package edu.iesam.laligatracker.features.clubs.data.local.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ClubsDao {

    @Query("SELECT * FROM $CLUBS_TABLE")
    suspend fun findAllClubs(): List<ClubEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllClubs(vararg clubEntity: ClubEntity)
}