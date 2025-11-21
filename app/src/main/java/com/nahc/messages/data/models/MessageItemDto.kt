package com.nahc.messages.data.models

import com.nahc.messages.domain.model.MessageItem

data class MessageItemDto(
    val id: String,
    val message: String,
){
    fun toDomain() : MessageItem{
        return MessageItem(
            id = id,
            message = message
        )
    }
}
