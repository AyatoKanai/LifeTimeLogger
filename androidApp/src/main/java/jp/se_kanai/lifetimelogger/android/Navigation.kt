package jp.se_kanai.lifetimelogger.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.se_kanai.lifetimelogger.android.ui.screen.HomeScreen
import jp.se_kanai.lifetimelogger.navigation.Screen


@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.id) {
        composable(Screen.Home.id) {
            HomeScreen()
        }

//        composable(
//            Screen.SettingCustomFieldList.route,
//            arguments = listOf(navArgument("field_index") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val fieldIndex = backStackEntry.arguments?.getInt("field_index") ?: 1
//            CustomFieldListSettingScreen(
//                navController = navController,
////                        drawerState = drawerState
//                fieldIndex = fieldIndex
//            )
//        }
    }
}
