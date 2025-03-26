package edu.iesam.laligatracker.features.players.data

import edu.iesam.laligatracker.features.players.domain.Player
import edu.iesam.laligatracker.features.players.domain.PlayersRepository

class PlayersDataRepository(): PlayersRepository {
    override suspend fun getPlayers(): List<Player> {
        TODO("Not yet implemented")
    }
}