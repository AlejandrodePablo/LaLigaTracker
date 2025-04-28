package edu.iesam.laligatracker.features.clubs.presentation.market

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.laligatracker.features.clubs.domain.Club
import edu.iesam.laligatracker.features.clubs.domain.GetClubsByMarketValueUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MarketValueViewModel(
    private val getClubsByMarketValueUseCase: GetClubsByMarketValueUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState


    fun fetchClubsByMarketValue() {
        viewModelScope.launch(Dispatchers.IO) {
            val clubs = getClubsByMarketValueUseCase.invoke()
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