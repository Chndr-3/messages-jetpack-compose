package com.nahc.messages.domain.repository

import com.nahc.messages.domain.model.ApiResponse

interface MessageRepository {
    suspend fun getListMessages() : List<MessageRepository>

    suspend fun postMessages(text: String): ApiResponse
    suspend fun getListById(id: String): MessageRepository
}