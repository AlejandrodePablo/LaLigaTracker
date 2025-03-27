package edu.iesam.laligatracker.features.players.data.remoto

import edu.iesam.laligatracker.features.players.domain.Player

fun PlayerApiModel.toModel(): Player {
    return Player(this.id, this.name, this.number, this.image, this.amountGoals)
}