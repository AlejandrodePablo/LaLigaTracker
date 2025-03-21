package edu.iesam.laligatracker.features.clubs.data.remote

import edu.iesam.laligatracker.features.clubs.domain.Club
import org.koin.core.annotation.Single

@Single
class ClubApiRemoteDataSource(private val clubApi: ClubService) {

    suspend fun getClubs(): List<Club> {
        val response = clubApi.requestClubs()
        return if (response.isSuccessful) {
            val clubList = response.body()?.clubs ?: emptyList()

            clubList.mapNotNull { clubItem ->
                val profileResponse = clubApi.getClubProfile(clubItem.id)

                if (profileResponse.isSuccessful) {
                    val profileData = profileResponse.body()

                    profileData?.toModel()?.apply {
                        image = profileData.image
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