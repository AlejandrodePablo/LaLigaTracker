package edu.iesam.laligatracker.features.players.data.local.db

import edu.iesam.laligatracker.features.players.domain.Player

class PlayersDbLocalDataSource(private val playersDao: PlayersDao) {

    suspend fun findAllPlayers(): List<Player> {
        val players = playersDao.findAllPlayers()
        return if (players.isEmpty()) {
            emptyList()
        } else (players.map { it.toDomain() })
    }

    suspend fun saveAllPlayers(players: List<Player>) {
        val playerList = players.map {
            it.toEntity()
        }
        playersDao.saveAllPlayers(*playerList.toTypedArray())
    }
}