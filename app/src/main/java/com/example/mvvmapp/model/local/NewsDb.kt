package com.example.mvvmapp.model.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmapp.model.data.Article

@Database(
    entities = [Article::class],
    version = NewsDbMigration.latestVersion
)
abstract class NewsDb : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        private const val dbName = "news_db"

        fun buildDefault(context: Context) =
            Room.databaseBuilder(context, NewsDb::class.java, dbName)
                .addMigrations(*NewsDbMigration.allMigrations)
                .build()

        @VisibleForTesting
        fun buildTest(context: Context) =
            Room.inMemoryDatabaseBuilder(context, NewsDb::class.java)
                .build()
    }
}