package edu.iesam.laligatracker.features.players.data.remoto

import edu.iesam.laligatracker.features.players.domain.Player
import edu.iesam.laligatracker.features.players.domain.Stats

fun PlayerApiModel.toModel(stats: Stats): Player {
    return Player(
        this.id,
        this.name,
        this.image,
        this.number,
        stats = stats
    )
}

fun StatsApiModel.toModel(): Stats {
    return Stats(this.id, this.competitionId, this.amountGoals, this.amountAssists)
}