package edu.iesam.laligatracker.features.players.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.laligatracker.features.players.domain.GetPlayersUseCase
import edu.iesam.laligatracker.features.players.domain.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class PlayersViewModel(private val getPlayers: GetPlayersUseCase, private val clubId: String) :
    ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun fetchPlayers() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val players = getPlayers.invoke(clubId)
            _uiState.postValue(
                UiState(
                    players = players,
                    error = false
                )
            )
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val error: Boolean = true,
        val players: List<Player>? = null
    )
}