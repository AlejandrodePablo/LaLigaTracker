package edu.iesam.laligatracker.features.clubs.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ClubService {

    @GET("competitions/ES1/clubs")
    suspend fun requestClubs(): Response<List<ClubApiModel>>
}