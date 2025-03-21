package edu.iesam.laligatracker.features.clubs.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

data class ClubsResponse(
    val clubs: List<ClubListApiModel>
)

interface ClubService {

    @GET("competitions/ES1/clubs")
    suspend fun requestClubs(): Response<ClubsResponse>

    @GET("clubs/{club_id}/profile")
    suspend fun getClubProfile(@Path("club_id") clubId: String): Response<ClubProfileApiModel>
}