package edu.iesam.laligatracker.features.clubs.domain

import org.koin.core.annotation.Single

@Single
class GetClubsByMarketValueUseCase(private val repository: ClubRepository) {
    suspend operator fun invoke(): List<Club> {
        return repository.getClubs().toList().sortedByDescending { it.marketValue }
    }
}