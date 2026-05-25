package jp.se_kanai.lifetimelogger.android.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ホーム画面のレイアウト（表示はすべてダミー固定値）
// WHY: 画面の見た目を先に決めるため、ビジネスロジックやデータ取得は実装しない

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("LifeTime Logger") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ロジック不要 */ }) {
                Text("＋")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // 概要カード（固定ダミー値）
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SummaryCard(modifier = Modifier.weight(1f).height(88.dp), title = "Total Time", value = "123 h")
                SummaryCard(modifier = Modifier.weight(1f).height(88.dp), title = "Today", value = "2 h 30 m")
                SummaryCard(modifier = Modifier.weight(1f).height(88.dp), title = "Streak", value = "5 days")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // 最近の記録一覧（ダミー項目）
            Text(
                text = "Recent Entries",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            val itemsList = listOf(
                EntryData("Morning Run", "Running", "1 h 15 m"),
                EntryData("Work Session", "Coding", "3 h 10 m"),
                EntryData("Reading", "Leisure", "45 m")
            )

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(itemsList) { item ->
                    EntryCard(title = item.title, subtitle = item.subtitle, duration = item.duration)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
private fun SummaryCard(modifier: Modifier = Modifier, title: String, value: String) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = title, fontSize = 12.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

data class EntryData(val title: String, val subtitle: String, val duration: String)

@Composable
private fun EntryCard(title: String, subtitle: String, duration: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = subtitle, fontSize = 12.sp, color = Color.Gray)
            }
            Text(text = duration, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    _root_ide_package_.jp.se_kanai.lifetimelogger.android.MyApplicationTheme {
        HomeScreen()
    }
}


