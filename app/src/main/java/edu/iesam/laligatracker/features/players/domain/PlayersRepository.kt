package edu.iesam.laligatracker.features.players.domain

interface PlayersRepository {
    suspend fun getPlayers(): List<Player>
}