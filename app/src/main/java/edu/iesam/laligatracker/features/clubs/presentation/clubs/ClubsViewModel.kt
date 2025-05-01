package edu.iesam.laligatracker.features.clubs.presentation.clubs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.laligatracker.features.clubs.domain.Club
import edu.iesam.laligatracker.features.clubs.domain.GetClubsUseCase
import edu.iesam.laligatracker.features.clubs.domain.GetFavoriteClubsUseCase
import edu.iesam.laligatracker.features.clubs.domain.ToggleFavoriteClubsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClubsViewModel(
    private val getClubsUseCase: GetClubsUseCase,
    private val getFavoriteClubUseCase: GetFavoriteClubsUseCase,
    private val toggleFavoriteClubUseCase: ToggleFavoriteClubsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState

    fun fetchClubs() {
        _uiState.value = UiState(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val clubs = getClubsUseCase.invoke()
            _uiState.postValue(
                UiState(
                    clubs = clubs,
                    errorApp = false
                )
            )
        }
    }

    fun loadFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            val clubsFavorites = getFavoriteClubUseCase()
            _uiState.postValue(
                UiState(
                    clubs = clubsFavorites,
                    errorApp = false
                )
            )
        }
    }

//    fun toggleFavorite(club: Club, isFavoriteView: Boolean) {
//        viewModelScope.launch(Dispatchers.IO) {
//            toggleFavoriteClubUseCase(club)
//            _uiState.value?.clubs?.let { currentClubs ->
//                val updatedClubs = currentClubs.map {
//                    if (it.club.id == club.id) it.copy(isFavorite = !it.isFavorite) else it
//                }
//                _uiState.postValue(
//                    UiState(
//                        clubs = updatedClubs,
//                        errorApp = false
//                    )
//                )
//            }
//        }
//    }

    fun toggleFavorite(club: Club, isFavoriteView: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            toggleFavoriteClubUseCase(club)
            _uiState.value?.clubs?.let { currentClubs ->
                val updatedClubs = currentClubs.mapNotNull {
                    if (it.club.id == club.id) {
                        val updatedClub = it.copy(isFavorite = !it.isFavorite)
                        if (isFavoriteView && !updatedClub.isFavorite) null else updatedClub
                    } else it
                }
                _uiState.postValue(
                    UiState(
                        clubs = updatedClubs,
                        errorApp = false
                    )
                )
            }
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: Boolean = true,
        val clubs: List<GetClubsUseCase.ClubFeed>? = null
    )
}