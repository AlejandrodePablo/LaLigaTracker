package edu.iesam.laligatracker.features.clubs.domain

import org.koin.core.annotation.Single

@Single
class ToggleFavoriteClubsUseCase(private val clubRepository: ClubRepository) {
    suspend operator fun invoke(club: Club){
        clubRepository.toggleFavoriteClub(club)
    }
}