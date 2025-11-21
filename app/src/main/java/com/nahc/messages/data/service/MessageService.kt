package com.nahc.messages.data.service

import com.nahc.messages.data.models.ApiResponse
import com.nahc.messages.domain.model.MessageItem
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MessageService {
    @GET("messages")
    suspend fun getListMessages(): List<MessageItem>

    @POST("messages")
    suspend fun postMessages(@Body text: String): ApiResponse

    @GET("messages/{id}")
    suspend fun getListById(@Path("id") id: String): MessageItem
}


