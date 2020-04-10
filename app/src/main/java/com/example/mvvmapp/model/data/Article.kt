package com.example.mvvmapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmapp.model.data.Article.Article.tableName

@Entity(tableName = tableName)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = Article.Column.author)
    val author: String? = null,

    @ColumnInfo(name = Article.Column.title)
    val title: String? = null,

    @ColumnInfo(name = Article.Column.description)
    val description: String? = null,

    @ColumnInfo(name = Article.Column.url)
    val url: String? = null,

    @ColumnInfo(name = Article.Column.urlToImage)
    val urlToImage: String? = null,

    @ColumnInfo(name = Article.Column.publishedAt)
    val publishedAt: String? = null
) {
    object Article {
        const val tableName = "article"

        object Column {
            const val id = "id"
            const val author = "author"
            const val title = "title"
            const val description = "description"
            const val url = "url"
            const val urlToImage = "urlToImage"
            const val publishedAt = "publishedAt"
        }
    }
}