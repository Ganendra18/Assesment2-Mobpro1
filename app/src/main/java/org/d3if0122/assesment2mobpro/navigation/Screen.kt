package org.d3if0122.assesment2mobpro.navigation

sealed class Screen (val route: String){
    data object Home: Screen("mainScreen")
}