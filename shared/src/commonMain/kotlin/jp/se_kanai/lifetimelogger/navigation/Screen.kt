package jp.se_kanai.lifetimelogger.navigation

sealed class Screen(val id: String) {
    object Home : Screen("home")

    // 実装例
    // object RecordInput : Screen("recordInput")
    // object RecordUpdate : Screen("recordUpdate/{id}") {
    //     fun createRoute(id: Long): String =
    //         "recordUpdate/$id"
    // }
}
