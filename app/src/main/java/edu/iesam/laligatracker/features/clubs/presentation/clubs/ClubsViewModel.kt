package edu.iesam.laligatracker.features.clubs.presentation.clubs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.laligatracker.features.clubs.domain.Club
import edu.iesam.laligatracker.features.clubs.domain.GetClubsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class ClubsViewModel(private val getClubsUseCase: GetClubsUseCase) : ViewModel() {

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

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: Boolean = true,
        val clubs: List<Club>? = null
    )
}