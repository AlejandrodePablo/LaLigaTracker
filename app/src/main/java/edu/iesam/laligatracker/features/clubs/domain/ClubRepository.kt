package edu.iesam.laligatracker.features.clubs.domain

interface ClubRepository {
    suspend fun getClubs(): List<Club>
    suspend fun getFavoriteClubs(): List<Club>
    suspend fun saveFavoriteClub(club: Club)
    suspend fun deleteFavoriteClub(club: Club)
    suspend fun toggleFavoriteClub(club: Club)
}