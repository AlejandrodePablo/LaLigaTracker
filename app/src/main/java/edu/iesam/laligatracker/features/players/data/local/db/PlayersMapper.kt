package edu.iesam.laligatracker.features.players.data.local.db

import edu.iesam.laligatracker.features.players.domain.Player

fun Player.toEntity(): PlayersEntity = PlayersEntity(
    this.id,
    this.name,
    this.image,
    this.number,
    this.amountGoals
)

fun PlayersEntity.toDomain(): Player = Player(
    this.id,
    this.name,
    this.image,
    this.number,
    this.amountGoals
)