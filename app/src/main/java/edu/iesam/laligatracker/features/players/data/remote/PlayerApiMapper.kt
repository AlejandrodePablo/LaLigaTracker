package edu.iesam.laligatracker.features.players.data.remote

import android.util.Log
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
    Log.d("@dev", "Mapping StatsApiModel to Stats: amountGoals=${this.amountGoals}")
    return Stats(
        this.id,
        "ES1",
        this.amountGoals,
        this.amountAssists)
}