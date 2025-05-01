package edu.iesam.laligatracker.features.clubs.domain

import org.koin.core.annotation.Single

@Single
class GetClubsUseCase(private val clubRepository: ClubRepository) {
    suspend operator fun invoke(): List<ClubFeed> {
        val resultClubs = clubRepository.getClubs()
        val favoriteClubs = clubRepository.getFavoriteClubs()
        val clubsFeed = mutableListOf<ClubFeed>()
        resultClubs.forEach { club ->
            clubsFeed.add(
                ClubFeed(
                    club,
                    favoriteClubs.find { favoriteClub ->
                        favoriteClub.id == club.id
                    } != null
                )
            )
        }
        return clubsFeed.sortedByDescending { it.club.stadiumSeats }
    }

    data class ClubFeed(
        val club: Club,
        val isFavorite: Boolean
    )
}