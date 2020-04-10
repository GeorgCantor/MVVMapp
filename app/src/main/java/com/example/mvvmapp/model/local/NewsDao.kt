package com.example.mvvmapp.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.mvvmapp.model.data.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Insert
    fun insertArticles(articles: List<Article>): List<Long>

    @Query("DELETE FROM article")
    fun clearAllArticles()

    @Transaction
    fun clearAndCacheArticles(articles: List<Article>) {
        clearAllArticles()
        insertArticles(articles)
    }

    @Query("SELECT * FROM article")
    fun getArticles(): Flow<List<Article>>
}