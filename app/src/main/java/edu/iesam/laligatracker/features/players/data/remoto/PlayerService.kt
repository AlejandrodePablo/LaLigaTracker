package edu.iesam.laligatracker.features.players.data.remoto

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerService {

    @GET("club/{club_id}/players")
    suspend fun requestPlayers(@Path("club_id") clubId: String): Response<PlayerInfoApiModel>

    @GET("players/{player_id}/profile")
    suspend fun getPlayerInfo(@Path("player_id") playerId: String): Response<PlayerApiModel>
}