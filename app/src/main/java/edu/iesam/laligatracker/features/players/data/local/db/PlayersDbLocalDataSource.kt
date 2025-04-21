package edu.iesam.laligatracker.features.players.data.local.db

import edu.iesam.laligatracker.features.players.domain.Player
import org.koin.core.annotation.Single

@Single
class PlayersDbLocalDataSource(private val playersDao: PlayersDao) {

    suspend fun findAllPlayers(clubId: String): List<Player> {
        val players = playersDao.findAllPlayers(clubId)
        return if (players.isEmpty()) {
            emptyList()
        } else {
            players.map { playersWithStats ->
                val player =
                    playersWithStats.player.toDomain(
                        playersWithStats.stats.firstOrNull()?.toDomain() ?: error("stats not found")
                    )
                player
            }
        }
    }

    suspend fun saveAllPlayers(players: List<Player>, clubId: String) {
        val playerEntities = players.map { it.toEntity(clubId) }
        val statsEntities = players.flatMap {
            it.stats.let { listOf(it.toEntity(it.id)) }
        }
        playersDao.saveAllPlayers(*playerEntities.toTypedArray())
        playersDao.saveAllStats(*statsEntities.toTypedArray())
    }
}