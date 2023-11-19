@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navigatonexample.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAnotherAppBar(navigateBack: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = "Third Screen",
            style = MaterialTheme.typography.displaySmall
        )
    },
        navigationIcon = {
            IconButton(onClick =  navigateBack ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    )
}


@Composable
fun ThirdScreen( navigateBack:() -> Unit) {
    Scaffold(
        topBar = {
            MyAnotherAppBar(navigateBack)
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding), contentAlignment = Alignment.Center) {
            Column {
                Text(
                    text = "Welcome to 3rd Screen",
                    style = MaterialTheme.typography.displaySmall
                )

            }
        }
    }
}

