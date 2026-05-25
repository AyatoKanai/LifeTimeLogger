package jp.se_kanai.lifetimelogger.navigation

sealed class Screen(val id: String) {
    object Home : Screen("home")
    object ActivityEdit : Screen("activity_edit?activityLogId={activityLogId}") {
        fun createRoute(activityLogId: Long? = null): String {
            return if (activityLogId != null) {
                "activity_edit?activityLogId=$activityLogId"
            } else {
                "activity_edit"
            }
        }
    }
    object CategoryList : Screen("category_list")
    object SubcategoryList : Screen("subcategory_list")
    object LabelList : Screen("label_list")
    object PresetList : Screen("preset_list")
    object Timeline : Screen("timeline")
    object Analysis : Screen("analysis")
    object Settings : Screen("settings")
}
