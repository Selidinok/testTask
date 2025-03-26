package com.example.testtask.main.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.testtask.compose.ErrorContent
import com.example.testtask.compose.Loading
import com.example.testtask.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
) {
    val viewModel: MainViewModel = hiltViewModel()
    LaunchedEffect(Unit) { viewModel.onRefresh() }
    val state = viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Test app")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(
                        onClick = { navController.navigate(Screens.CreateScreen(null)) },
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Create,
                            contentDescription = "Create",
                        )
                    }
                }
            )
        }
    ) { padding ->
        val state = state.value
        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
        ) {
            when {
                state.isLoading -> Loading()
                state.error != null -> ErrorContent(state.error, viewModel::onRefresh)
                else -> Content(state, navController)
            }
        }
    }
}

@Composable
private fun Content(
    state: MainState,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(state.notes) { item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(Screens.NoteScreen(item.id)) }
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = item.title,
                )
            }
        }
    }
}