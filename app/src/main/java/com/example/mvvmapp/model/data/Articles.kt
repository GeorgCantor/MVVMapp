package com.example.mvvmapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmapp.model.data.Articles.Articles.tableName
import com.google.gson.annotations.SerializedName

@Entity(tableName = tableName)
data class Articles(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = Articles.Column.author)
    val author: String? = null,

    @ColumnInfo(name = Articles.Column.title)
    val title: String? = null,

    @ColumnInfo(name = Articles.Column.description)
    val description: String? = null,

    @ColumnInfo(name = Articles.Column.url)
    val url: String? = null,

    @ColumnInfo(name = Articles.Column.urlToImage)
    val urlToImage: String? = null,

    @ColumnInfo(name = Articles.Column.publishedAt)
    val publishedAt: String? = null
) {
    object Articles {
        const val tableName = "news_article"

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