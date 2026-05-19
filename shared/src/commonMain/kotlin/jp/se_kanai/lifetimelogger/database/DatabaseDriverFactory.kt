package jp.se_kanai.lifetimelogger.database

import app.cash.sqldelight.db.SqlDriver
import jp.se_kanai.Database

expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

fun createDatabase(driverFactory: DatabaseDriverFactory): Database {
    val driver = driverFactory.createDriver()
    val database = Database(driver)

    return database
}
