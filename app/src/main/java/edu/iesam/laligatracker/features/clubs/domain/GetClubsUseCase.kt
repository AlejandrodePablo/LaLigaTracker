package edu.iesam.laligatracker.features.clubs.domain

import org.koin.core.annotation.Single

@Single
class GetClubsUseCase(private val clubRepository: ClubRepository) {
    suspend operator fun invoke(): List<Club> {
        return clubRepository.getClubs()
    }
}