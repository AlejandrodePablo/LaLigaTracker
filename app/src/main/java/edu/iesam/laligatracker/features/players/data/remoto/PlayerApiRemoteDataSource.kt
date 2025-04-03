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
                val playerInfoResponse = playerService.getPlayerInfo(playerApiModel.id)
                if (statsResponse.isSuccessful && playerInfoResponse.isSuccessful) {
                    val statsApiModel = statsResponse.body()
                    val playerInfoApiModel = playerInfoResponse.body()
                    statsApiModel?.let {
                        playerApiModel.toModel(it.toModel(), playerInfoApiModel?.image ?:"", playerInfoApiModel?.number?:"")
                    }
                } else {
                    null
                }
            }
        } else {
            emptyList()
        }
    }
}