package jp.se_kanai.lifetimelogger.android

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import jp.se_kanai.lifetimelogger.android.ui.screen.HomeScreen
import jp.se_kanai.lifetimelogger.navigation.Screen


@Composable
fun AppNav() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.Home.id) {
        composable(Screen.Home.id) {
            HomeScreen()
        }

        composable(
            route = Screen.ActivityEdit.id,
            arguments = listOf(navArgument("activityLogId") {
                type = NavType.StringType
                nullable = true
                defaultValue = null
            })
        ) { backStackEntry ->
            val idStr = backStackEntry.arguments?.getString("activityLogId")
            val id = idStr?.toLongOrNull()
            // TODO: ActivityEditScreen を作成して呼び出す
            Text("Activity Edit Screen (ID: $id)")
        }

        composable(Screen.CategoryList.id) {
            Text("Category List Screen")
        }

        composable(Screen.SubcategoryList.id) {
            Text("Subcategory List Screen")
        }

        composable(Screen.LabelList.id) {
            Text("Label List Screen")
        }

        composable(Screen.PresetList.id) {
            Text("Preset List Screen")
        }

        composable(Screen.Timeline.id) {
            Text("Timeline Screen")
        }

        composable(Screen.Analysis.id) {
            Text("Analysis Screen")
        }

        composable(Screen.Settings.id) {
            Text("Settings Screen")
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
