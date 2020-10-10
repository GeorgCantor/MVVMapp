package com.example.mvvmapp.model.datasource

import androidx.paging.PagingSource
import com.example.mvvmapp.model.ApiService
import com.example.mvvmapp.model.response.Article

class NewsDataSource(private val apiService: ApiService) : PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        try {
            val nextPageNumber = params.key ?: 1
            val response = apiService.getNews("usa", nextPageNumber)
            val responseData = mutableListOf<Article>()
            val data = response.body()?.articles ?: emptyList()
            responseData.addAll(data)

            val prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1

            return LoadResult.Page(
                data = responseData,
                prevKey = prevKey,
                nextKey = nextPageNumber.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}