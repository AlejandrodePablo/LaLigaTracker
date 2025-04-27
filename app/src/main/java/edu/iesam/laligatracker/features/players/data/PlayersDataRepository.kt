package edu.iesam.laligatracker.features.players.data

import edu.iesam.laligatracker.features.players.data.local.db.PlayersDbLocalDataSource
import edu.iesam.laligatracker.features.players.data.remote.PlayerApiRemoteDataSource
import edu.iesam.laligatracker.features.players.domain.Player
import edu.iesam.laligatracker.features.players.domain.PlayersRepository
import org.koin.core.annotation.Single

@Single
class PlayersDataRepository(
    private val local: PlayersDbLocalDataSource,
    private val remote: PlayerApiRemoteDataSource
) : PlayersRepository {
    override suspend fun getPlayers(clubId: String): List<Player> {
        val playerLocal = local.findAllPlayers(clubId)
        if (playerLocal.isEmpty()) {
            val playersRemote = remote.getPlayers(clubId)
            local.saveAllPlayers(playersRemote, clubId)
            return playersRemote
        }
        return playerLocal
    }
}