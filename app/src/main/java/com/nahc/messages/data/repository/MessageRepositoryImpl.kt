package com.nahc.messages.data.repository

import com.nahc.messages.domain.model.ApiResponse
import com.nahc.messages.domain.repository.MessageRepository

class MessageRepositoryImpl : MessageRepository  {
    override suspend fun getListMessages(): List<MessageRepository> {
        TODO("Not yet implemented")
    }

    override suspend fun postMessages(text: String): ApiResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getListById(id: String): MessageRepository {
        TODO("Not yet implemented")
    }


}
