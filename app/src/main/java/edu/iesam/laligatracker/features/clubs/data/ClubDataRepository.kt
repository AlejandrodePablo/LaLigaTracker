package edu.iesam.laligatracker.features.clubs.data

import edu.iesam.laligatracker.features.clubs.data.local.db.ClubDbLocalDataSource
import edu.iesam.laligatracker.features.clubs.data.remote.ClubApiRemoteDataSource
import edu.iesam.laligatracker.features.clubs.domain.Club
import edu.iesam.laligatracker.features.clubs.domain.ClubRepository
import org.koin.core.annotation.Single

@Single
class ClubDataRepository(
    private val local: ClubDbLocalDataSource,
    private val remote: ClubApiRemoteDataSource
) : ClubRepository {

    override suspend fun getClubs(): List<Club> {
        val clubsLocal = local.findAll()
        if (clubsLocal.isEmpty()) {
            val clubsRemote = remote.getClubs()
            local.saveAll(clubsRemote)
            return clubsRemote
        }
        return clubsLocal
    }

    override suspend fun getFavoriteClubs(): List<Club> {
        return local.getFavoriteClubs()
    }

    override suspend fun saveFavoriteClub(club: Club) {
        local.saveFavorite(club)
    }

    override suspend fun deleteFavoriteClub(club: Club) {
        local.deleteFavorite(club)
    }

    override suspend fun toggleFavoriteClub(club: Club) {
        local.toggleFavorite(club)
    }
}