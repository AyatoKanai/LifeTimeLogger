package jp.se_kanai.lifetimelogger.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import jp.se_kanai.lifetimelogger.android.ui.screen.HomeScreen
import jp.se_kanai.lifetimelogger.database.DatabaseDriverFactory
import jp.se_kanai.lifetimelogger.database.createDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = createDatabase(DatabaseDriverFactory(this))

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // ホーム画面のレイアウトを表示（ロジックは不要なので固定ダミー値）
                    HomeScreen()
                }
            }
        }
    }
}
