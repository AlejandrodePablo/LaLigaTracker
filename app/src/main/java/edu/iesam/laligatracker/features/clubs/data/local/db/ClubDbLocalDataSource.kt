package edu.iesam.laligatracker.features.clubs.data.local.db

import edu.iesam.laligatracker.features.clubs.domain.Club
import org.koin.core.annotation.Single

@Single
class ClubDbLocalDataSource(private val clubsDao: ClubsDao, private val favoriteDao: FavoriteDao) {

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

    suspend fun findClubById(clubId: String): Club? {
        return clubsDao.findById(clubId)?.toDomain()
    }

    suspend fun getFavoriteClubs(): List<Club> {
        val favoriteEntities = favoriteDao.getFavorites()
        val favoriteClubs = favoriteEntities.mapNotNull {
            clubsDao.findById(it.id)?.toDomain()
        }
        return favoriteClubs
    }

    suspend fun saveFavorite(club: Club) {
        val favoriteEntity = FavoriteEntity(club.id, favorite = true)
        favoriteDao.addFavorite(favoriteEntity)
    }

    suspend fun deleteFavorite(club: Club) {
        val favoriteEntity = FavoriteEntity(club.id, favorite = true)
        favoriteDao.deleteFavorite(favoriteEntity)
    }

    suspend fun toggleFavorite(club: Club) {
        val favoriteEntity = favoriteDao.findById(club.id)
        if (favoriteEntity == null) {
            saveFavorite(club)
        } else {
            deleteFavorite(club)
        }
    }
}