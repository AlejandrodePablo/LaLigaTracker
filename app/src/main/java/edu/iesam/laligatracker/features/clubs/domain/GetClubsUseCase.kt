package edu.iesam.laligatracker.features.clubs.domain

class GetClubsUseCase(private val clubRepository: ClubRepository) {
    suspend operator fun invoke(): List<Club> {
        return clubRepository.getClubs()
    }
}