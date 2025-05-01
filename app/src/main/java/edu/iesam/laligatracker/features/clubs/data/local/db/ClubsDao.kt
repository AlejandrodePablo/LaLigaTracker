package edu.iesam.laligatracker.features.clubs.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ClubsDao {

    @Query("SELECT * FROM $CLUBS_TABLE")
    suspend fun findAllClubs(): List<ClubEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllClubs(vararg clubEntity: ClubEntity)

    @Query("SELECT * FROM $CLUBS_TABLE WHERE club_id = :clubId LIMIT 1")
    suspend fun findById(clubId: String): ClubEntity?
}