package com.example.mvvmapp.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ArticleViewModel::class)
    fun bindArticleViewModel(newsArticleViewModel: ArticleViewModel): ViewModel
}