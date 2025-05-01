package edu.iesam.laligatracker.features.clubs.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val FAVORITE_TABLE = "favorite_clubs"
const val FAVORITE_ID = "id"

@Entity(tableName = FAVORITE_TABLE)
class FavoriteEntity(
    @PrimaryKey @ColumnInfo(name = FAVORITE_ID) val id: String,
    @ColumnInfo(name = "favoriteClub") val favorite: Boolean = false
)