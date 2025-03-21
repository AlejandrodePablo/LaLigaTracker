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
}