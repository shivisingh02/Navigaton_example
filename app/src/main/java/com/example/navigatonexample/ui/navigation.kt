package com.example.navigatonexample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigatonexample.ui.screen.FirstScreen
import com.example.navigatonexample.ui.screen.SecondScreen
import com.example.navigatonexample.ui.screen.ThirdScreen

enum class Screen{
    First,
    Second,
    Third
}
@Composable
fun Navigation() {
    //step 1 - create a nav controller object
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.First.name ){
        composable(Screen.First.name){ FirstScreen(
            navigateToNext = {    //explaining the working of this lambda function
                navController.navigate(Screen.Second.name)
            }
        )}
        composable(Screen.Second.name){
            SecondScreen(navigateToForward = { navController.navigate(Screen.Third.name) },
                navigateUp = {navController.navigateUp()})

        }
        composable(Screen.Third.name){
            ThirdScreen(navigateBack = {navController.navigateUp()
            })


        }

    }

}