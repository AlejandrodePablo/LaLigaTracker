package edu.iesam.laligatracker.features.players.data.local.db

import edu.iesam.laligatracker.features.players.domain.Player
import edu.iesam.laligatracker.features.players.domain.Stats

fun Player.toEntity(): PlayersEntity = PlayersEntity(
    this.id,
    this.name,
    this.image,
    this.number,
    this.stats.amountGoals,
    this.stats.amountAssists
)

fun PlayersEntity.toDomain(): Player = Player(
    this.id,
    this.name,
    this.image,
    this.number,
    Stats(
        id = id,
        competitionId = "ES1",
        amountGoals = amountGoals,
        amountAssists = amountAssists
    )
)

fun Stats.toEntity(playerId: String): StatsEntity = StatsEntity(
    this.id,
    this.competitionId,
    this.amountGoals,
    this.amountAssists,
    playerId = playerId
)

fun StatsEntity.toDomain(): Stats = Stats(
    this.id,
    this.competitionId,
    this.amountGoals,
    this.amountAssists
)