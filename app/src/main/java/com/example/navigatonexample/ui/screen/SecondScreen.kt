@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navigatonexample.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.navigatonexample.ui.theme.NavigatonExampleTheme

@Composable
fun SecondScreen(
    navigateToForward: () -> Unit,
    navigateUp: () -> Unit
) {
    Scaffold(
        topBar = { MyTopBar(navigateUp) },
        floatingActionButton = { MyFab(navigateToForward) }
    )
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding), contentAlignment = Alignment.Center) {
            Column {
                Text(
                    text = "Welcome to 2nd Screen",
                    style = MaterialTheme.typography.displaySmall
                )

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(navigateUp: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = "Second Screen",
            style = MaterialTheme.typography.displaySmall
        )
    },
        navigationIcon = {
                         IconButton(onClick =  navigateUp ) {
                             Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)

                         }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        )
    )
}

@Composable
fun MyFab(navigateToForward: () -> Unit) {
    FloatingActionButton(onClick =  navigateToForward) {
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
    }
}

@Preview
@Composable
fun MyFabPreview(){
    NavigatonExampleTheme {
        SecondScreen(navigateToForward = { },
            navigateUp = {})
    }
}
@Preview
@Composable
fun TopBarPreview(){
    NavigatonExampleTheme {
        MyTopBar(navigateUp = {})

    }
}

@Preview
@Composable
fun SecondScreenPreview(){
    NavigatonExampleTheme {
        SecondScreen(navigateToForward = { /*TODO*/ },
            navigateUp = {})


    }
}