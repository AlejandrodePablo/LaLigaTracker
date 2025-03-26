package edu.iesam.laligatracker.features.players.data.remoto

import retrofit2.Response
import retrofit2.http.GET

interface PlayerService {

    @GET("players/{player_id}/stats")
    suspend fun requestPlayers(): Response<PlayerApiModel>
}