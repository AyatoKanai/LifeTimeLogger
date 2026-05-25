# AGENTS instructions

## Project Overview
- 要件は`SPEC.md`を参照すること

## Architecture
- Kotlin Multiplatform
- Jetpack Compose
- SQLDelight
- MVVM + Repository

### ViewModel
- `shared`に実装
- プラットフォーム間の互換性を保つため、Androidの `androidx.lifecycle.ViewModel` は直接使用せず、必要な処理をまとめた`BaseViewModel`を継承して実装
- 画面に出すデータは基本的に`UiState`クラスとして定義して画面ごとに一元管理

### Repository
- `Database` (SQLDelight) や `DataStore` へのアクセスをカプセル化する。
- リアクティブなデータ取得には `Flow` を返し、DBの変更を自動検知するように実装する。

### Database
- 基本的に`Repository` 経由で操作を行う。

## Code Style
### Naming
- クラス名: PascalCase
- メソッド・プロパティ名: camelCase
- DBカラム名: snake_case (SQLDelightの規約に従う)

### Comment
- 基本的に日本語で統一する。
- WHYに関するコメントを中心に記載する。
- WHATは最低限、コードから読み取りにくい場合に限定する。

## Boundaries

