package edu.iesam.laligatracker.features.players.domain

import org.koin.core.annotation.Single

@Single
class GetPlayersUseCase(private val playersRepository: PlayersRepository) {
    suspend operator fun invoke(clubId: String): List<Player> = playersRepository.getPlayers(clubId)
}