package edu.iesam.laligatracker.features.players.data.local.db

import edu.iesam.laligatracker.features.players.domain.Player
import edu.iesam.laligatracker.features.players.domain.Stats

fun Player.toEntity(): PlayersEntity = PlayersEntity(
    this.id,
    this.name,
    this.image,
    this.number?: "0"
)

fun PlayersEntity.toDomain(stats: Stats): Player = Player(
    this.id,
    this.name,
    this.image,
    this.number,
    stats
)

fun Stats.toEntity(playerId: String): StatsEntity = StatsEntity(
    this.id,
    this.competitionId,
    this.amountGoals ?: "0",
    this.amountAssists ?: "0",
    playerId = playerId
)

fun StatsEntity.toDomain(): Stats = Stats(
    this.id,
    this.competitionId,
    this.amountGoals,
    this.amountAssists
)