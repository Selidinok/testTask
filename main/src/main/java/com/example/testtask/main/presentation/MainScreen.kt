package com.example.testtask.main.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.testtask.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController,
) {
    val viewModel: MainViewModel = hiltViewModel()
    LaunchedEffect(Unit) { viewModel.onEnterScreen() }
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
                        onClick = { navController.navigate(Screens.CreateScreen) },
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
        val data = state.value
        PullToRefreshBox(
            modifier = Modifier.padding(padding),
            isRefreshing = data.isLoading,
            onRefresh = viewModel::onSwipe,
        ) {
            if (data.error != null) {
                ErrorContent(data.error, viewModel)
            } else {
                Content(data, navController)
            }
        }
    }
}

@Composable
private fun BoxScope.ErrorContent(
    error: String,
    viewModel: MainViewModel
) {
    Column(
        modifier = Modifier.Companion
            .align(Alignment.Center)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = error)
        IconButton(
            onClick = viewModel::onRefresh,
        ) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Create",
            )
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
                onClick = { navController.navigate(Screens.NoteScreen) }
            ) {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = item.title,
                )
            }
        }
    }
}