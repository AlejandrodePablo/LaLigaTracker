package edu.iesam.laligatracker.features.clubs.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val CLUBS_TABLE = "clubs"
const val CLUB_ID = "club_id"

@Entity(tableName = CLUBS_TABLE)
class ClubEntity(
    @PrimaryKey @ColumnInfo(name = CLUB_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String
)