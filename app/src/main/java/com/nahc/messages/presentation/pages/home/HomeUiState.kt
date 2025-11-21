package com.nahc.messages.presentation.pages.home

import com.nahc.messages.domain.model.MessageItem

sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Success(val messages: List<MessageItem>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}
