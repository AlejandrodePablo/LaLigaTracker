package edu.iesam.laligatracker.features.players.data.remoto

import edu.iesam.laligatracker.features.players.domain.Player
import org.koin.core.annotation.Single

@Single
class PlayerApiRemoteDataSource(private val playerService: PlayerService) {

    suspend fun getPlayers(clubId: String): List<Player> {
        val response = playerService.requestPlayers(clubId)
        return if (response.isSuccessful) {
            val playerList = response.body()?.players ?: emptyList()
            playerList.mapNotNull { playerApiModel ->
                val statsResponse = playerService.getPlayerStats(playerApiModel.id)
                if (statsResponse.isSuccessful) {
                    val statsApiModel = statsResponse.body()
                    statsApiModel?.let {
                        playerApiModel.toModel(it.toModel())
                    }
                } else {
                    null
                }
            }
        } else {
            emptyList()
        }
    }

    suspend fun getPlayer(playerId: String): Player? {
        val playerResponse = playerService.getPlayerInfo(playerId)
        return if (playerResponse.isSuccessful) {
            val playerApiModel = playerResponse.body()
            val statsResponse = playerService.getPlayerStats(playerId)
            if (statsResponse.isSuccessful) {
                val statsApiModel = statsResponse.body()
                if (playerApiModel != null && statsApiModel != null) {
                    playerApiModel.toModel(statsApiModel.toModel())
                } else {
                    null
                }
            } else {
                null
            }
        } else {
            null
        }
    }
}