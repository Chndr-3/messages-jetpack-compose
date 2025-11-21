package com.nahc.messages.domain.repository

import com.nahc.messages.data.models.ApiResponse
import com.nahc.messages.domain.model.MessageItem
import kotlinx.coroutines.flow.Flow

interface MessageRepository {
    suspend fun getListMessages() : List<MessageItem>

    suspend fun postMessages(text: String): ApiResponse
    suspend fun getListById(id: String): MessageItem
}