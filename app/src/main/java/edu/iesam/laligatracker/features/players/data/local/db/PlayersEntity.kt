package edu.iesam.laligatracker.features.players.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

const val PLAYERS_TABLE = "players"
const val PLAYER_ID = "player_id"
const val STATS_TABLE = "stats"
const val STAT_ID = "stat_id"

@Entity(tableName = PLAYERS_TABLE)
class PlayersEntity(
    @PrimaryKey @ColumnInfo(name = PLAYER_ID) val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "club_id") val clubId: String
)

@Entity(tableName = STATS_TABLE)
data class StatsEntity(
    @PrimaryKey @ColumnInfo(name = STAT_ID) val id: String,
    @ColumnInfo(name = "competition_id") val competitionId: String,
    @ColumnInfo(name = "amount_goals") val amountGoals: String,
    @ColumnInfo(name = "amount_assists") val amountAssists: String,
    @ColumnInfo(name = "player_id") val playerId: String
)

data class PlayerWithStats(
    @Embedded val player: PlayersEntity,
    @Relation(
        parentColumn = PLAYER_ID,
        entityColumn = "player_id"
    )
    val stats: List<StatsEntity>
)