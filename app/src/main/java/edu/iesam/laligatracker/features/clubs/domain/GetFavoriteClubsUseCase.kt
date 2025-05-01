package edu.iesam.laligatracker.features.clubs.domain

import org.koin.core.annotation.Single

@Single
class GetFavoriteClubsUseCase(private val clubRepository: ClubRepository) {
    suspend operator fun invoke(): List<GetClubsUseCase.ClubFeed> {
        return clubRepository.getFavoriteClubs().map {
            GetClubsUseCase.ClubFeed(
                it, true
            )
        }
    }
}
