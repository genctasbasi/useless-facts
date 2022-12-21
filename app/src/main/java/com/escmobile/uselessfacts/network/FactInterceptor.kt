package com.escmobile.uselessfacts.network

import okhttp3.Interceptor
import okhttp3.Response

const val API_KEY = "API"
const val API_VALUE = ""

class FactInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader(API_KEY, API_VALUE)
        val newRequest = requestBuilder.build()
        return chain.proceed(newRequest)
    }
}