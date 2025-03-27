package edu.iesam.laligatracker.features.players.data.local.db

import edu.iesam.laligatracker.features.players.domain.Player

class PlayersDbLocalDataSource(private val playersDao: PlayersDao) {

    suspend fun findAllPlayers(): List<Player> {
        val players = playersDao.findAllPlayers()
        return if (players.isEmpty()) {
            emptyList()
        } else {
            players.map { playersWithStats ->
                val player = playersWithStats.player.toDomain()
                val stats = playersWithStats.stats.map { it.toDomain() }
                player.copy(stats = stats.firstOrNull() ?: player.stats)
            }
        }
    }

    suspend fun saveAllPlayers(players: List<Player>) {
        val playerEntities = players.map { it.toEntity() }
        val statsEntities = players.flatMap {
            it.stats.let { listOf(it.toEntity(it.id)) }
        }
        playersDao.saveAllPlayers(*playerEntities.toTypedArray())
        playersDao.saveAllStats(*statsEntities.toTypedArray())
    }
}