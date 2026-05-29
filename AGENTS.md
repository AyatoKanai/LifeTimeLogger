# AGENTS instructions

## Project Overview
- 要件は`SPEC.md`を参照すること

## AI Operating Rules
- 推察で確定できない不明点がある場合は実装前に質問して確認する。
- Gitの操作は行わない。
- 複数の機能にまたがるような大規模な更新が生じる場合は一気に実装せず段階的に実装してレビューを求める。ただし一括で更新するよう指示があった場合はそれに従う。
- 既存の実装に問題がある場合は無理に踏襲せず改善案を提示する。
- 既存機能を壊す可能性がある変更は必ず事前説明する。

## Architecture
- Kotlin Multiplatform
- Jetpack Compose
- SQLDelight
- MVVM + Repository

### ViewModel
- プラットフォーム間の互換性を保つため、`shared`に実装
- プラットフォームごとに共有できないロジックはViewModelから切り出しつつ`expect/actual`などで対応
- 画面に出すデータは基本的に`UiState`クラスとして定義して画面ごとに一元管理

### Repository
- `Database` (SQLDelight) や `DataStore` へのアクセスをカプセル化する。
- リアクティブなデータ取得には `Flow` を返し、DBの変更を自動検知するように実装する。

### Database
- 基本的に`Repository` 経由で操作を行う。

## Code Style
### Text
- ログに記録する文章やUIに表示する文字は基本的に日本語で統一する。
- 多言語対応済みの場合にはUIに表示する文字は言語ごとに定義する。

### Naming
- クラス名: PascalCase
- メソッド・プロパティ名: camelCase
- DBカラム名: snake_case (SQLDelightの規約に従う)

### Comment
- 基本的に日本語で統一する。
- WHYに関するコメントを中心に記載する。
- WHATは最低限、コードから読み取りにくい場合に限定する。
- AIへの指示内容を記載するようなコメントは不要。純粋にソースコードとして必要なものだけにする。
