package edu.iesam.laligatracker.features.players.domain

data class Player(
    val id: String,
    val name: String,
    val image: String,
    val number: String,
    val stats: Stats
)

data class Stats(
    val id: String,
    val competitionId: String,
    val amountGoals: String,
    val amountAssists: String
)