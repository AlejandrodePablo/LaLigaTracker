package edu.iesam.laligatracker.features.players.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val PLAYERS_TABLE = "players"
const val PLAYER_ID = "player_id"

@Entity(tableName = PLAYERS_TABLE)
class PlayersEntity(
    @PrimaryKey @ColumnInfo(name = PLAYER_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "amount_goals") val amountGoals: String
)