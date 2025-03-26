package edu.iesam.laligatracker.features.players.domain

class GetPlayersUseCase(private val playersRepository: PlayersRepository) {
    suspend operator fun invoke(): List<Player> = playersRepository.getPlayers()
}