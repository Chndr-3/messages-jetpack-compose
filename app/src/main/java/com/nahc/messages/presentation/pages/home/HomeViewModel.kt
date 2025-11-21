package com.nahc.messages.presentation.pages.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nahc.messages.domain.usecase.GetListMessagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getListMessagesUseCase: GetListMessagesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadMessages()
    }

    fun loadMessages() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            try {
                val data = getListMessagesUseCase()  // suspend call
                _uiState.value = HomeUiState.Success(data)
            } catch (e: Exception) {
                _uiState.value =
                    HomeUiState.Error(e.message ?: "An unexpected error occurred")
            }
        }
    }
}

