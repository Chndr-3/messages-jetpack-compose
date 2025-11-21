package com.nahc.messages.presentation.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nahc.messages.domain.model.MessageItem
import com.nahc.messages.ui.theme.MessagesTheme
import com.nahc.messages.ui.theme.extendedColorScheme

@Composable
fun HomePage(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when (val state = uiState) {
                is HomeUiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is HomeUiState.Success -> {
                    MessagesList(
                        messages = state.messages
                    )
                }

                is HomeUiState.Error -> {
                    Text(
                        textAlign = TextAlign.Center,
                        text = state.message,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(32.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun MessagesList(
    modifier: Modifier = Modifier,
    messages: List<MessageItem>
) {
    LazyColumn(
        modifier = modifier.padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(messages) { message ->
            MessageItemBox(item = message)
        }
    }
}

@Composable
fun MessageItemBox(item: MessageItem) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.extendedColorScheme.card),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column {
                Text(text = "ID: ${item.id}")
                Text(text = item.message)
            }
        }
    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp,dpi=420")
@Composable
fun GreetingPreview() {
    MessagesTheme {
        val messages = listOf(
            MessageItem(message = "Hello", id = "1"),
            MessageItem(message = "World", id = "2"),
        )
        Scaffold { paddingValues ->
            MessagesList(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                messages = messages
            )
        }
    }
}

@Preview(device = "spec:width=411dp,height=891dp,dpi=420", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreviewDark() {
    MessagesTheme(darkTheme = true) {
        val messages = listOf(
            MessageItem(message = "Hello", id = "1"),
            MessageItem(message = "World", id = "2"),
        )
        Scaffold { paddingValues ->
            MessagesList(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                messages = messages
            )
        }
    }
}