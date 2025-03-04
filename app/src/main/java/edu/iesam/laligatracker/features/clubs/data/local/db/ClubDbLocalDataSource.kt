package edu.iesam.laligatracker.features.clubs.data.local.db

import edu.iesam.laligatracker.features.clubs.domain.Club
import org.koin.core.annotation.Single

@Single
class ClubDbLocalDataSource(private val clubsDao: ClubsDao) {

    suspend fun findAll(): List<Club> {
        val clubs = clubsDao.findAllClubs()
        return if (clubs.isEmpty()) {
            emptyList()
        } else (clubs.map { it.toDomain() })
    }

    suspend fun saveAll(clubs: List<Club>) {
        val clubsList = clubs.map {
            it.toEntity()
        }
        clubsDao.saveAllClubs(*clubsList.toTypedArray())
    }
}