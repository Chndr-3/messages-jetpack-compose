package com.nahc.messages.data.repository

import com.nahc.messages.data.models.ApiResponse
import com.nahc.messages.data.service.MessageService
import com.nahc.messages.domain.model.MessageItem
import com.nahc.messages.domain.repository.MessageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MessageRepositoryImpl @Inject constructor(private val messageApi: MessageService): MessageRepository  {
    override suspend fun getListMessages(): List<MessageItem> {
       return messageApi.getListMessages()
    }

    override suspend fun postMessages(text: String): ApiResponse {
        return messageApi.postMessages(text = text)
    }

    override suspend fun getListById(id: String): MessageItem {
        return messageApi.getListById(id = id)
    }
}
