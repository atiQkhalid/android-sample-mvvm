package com.example.mvvmapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mvvmapp.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                UserListScreen()
            }
        }
    }
}

@Composable
fun UserListScreen(viewModel: UserViewModel = hiltViewModel()) {
    val users by viewModel.users.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Users") }) }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(users) { user ->
                Text(
                    text = "${user.name} (${user.email})",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
