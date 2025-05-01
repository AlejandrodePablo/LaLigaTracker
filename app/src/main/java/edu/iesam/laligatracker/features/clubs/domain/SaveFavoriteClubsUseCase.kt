package edu.iesam.laligatracker.features.clubs.domain

import org.koin.core.annotation.Single

@Single
class SaveFavoriteClubsUseCase(private val clubRepository: ClubRepository) {
    suspend operator fun invoke(club: Club) {
        clubRepository.saveFavoriteClub(club)
    }
}