package edu.iesam.laligatracker.features.clubs.data.remote

import edu.iesam.laligatracker.features.clubs.domain.Club

class ClubApiRemoteDataSource(private val clubApi: ClubService) {

    suspend fun getClubs(): List<Club> {
        val response = clubApi.requestClubs()
        return if (response.isSuccessful) {
            response.body()!!.map {
                it.toModel()
            }
        } else {
            emptyList()
        }
    }
}