package com.example.mvvmapp.domain

import com.example.mvvmapp.model.data.Article
import com.example.mvvmapp.model.data.NewsResponse
import com.example.mvvmapp.model.local.NewsDao
import com.example.mvvmapp.model.remote.ApiService
import com.example.mvvmapp.view.ViewState
import dagger.Binds
import dagger.Module
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface ApiRepository {

    fun getArticles(): Flow<ViewState<List<Article>>>
}

@Singleton
class DefaultApiRepository @Inject constructor(
    private val dao: NewsDao,
    private val apiService: ApiService
) : ApiRepository {

    @ExperimentalCoroutinesApi
    override fun getArticles(): Flow<ViewState<List<Article>>> {
        return object : NetworkBoundResource<List<Article>, NewsResponse>() {
            override suspend fun saveNetworkResult(response: NewsResponse) =
                dao.clearAndCacheArticles(response.articles)

            override fun shouldFetch(data: List<Article>?) = true

            override fun loadFromDb() = dao.getArticles()

            override suspend fun fetchFromNetwork() = apiService.getNews()
        }
            .asFlow()
            .flowOn(Dispatchers.IO)
    }
}

@Module
interface ApiRepositoryModule {

    @Binds
    fun repository(apiRepository: DefaultApiRepository): ApiRepository
}