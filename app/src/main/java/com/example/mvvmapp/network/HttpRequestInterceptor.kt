package com.example.mvvmapp.network

import okhttp3.Interceptor

class HttpRequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain) =
        chain.proceed(chain.request().newBuilder().url(chain.request().url).build())
}
