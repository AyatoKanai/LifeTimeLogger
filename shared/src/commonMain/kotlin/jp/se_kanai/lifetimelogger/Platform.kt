package jp.se_kanai.lifetimelogger

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform