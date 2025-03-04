package edu.iesam.laligatracker.features.clubs.domain

interface ClubRepository {
    suspend fun getClubs(): List<Club>
}