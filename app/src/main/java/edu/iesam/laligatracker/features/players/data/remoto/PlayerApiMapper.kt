package edu.iesam.laligatracker.features.players.data.remoto

import edu.iesam.laligatracker.features.players.domain.Player
import edu.iesam.laligatracker.features.players.domain.Stats

fun PlayerApiModel.toModel(stats: Stats, imageUrl: String, number: String): Player {
    return Player(
        this.id,
        this.name,
        imageUrl,
        number,
        stats
    )
}

fun StatsApiModel.toModel(): Stats {
    return Stats(this.id, "ES1", this.amountGoals ?: "0", this.amountAssists ?: "0")
}