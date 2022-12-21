package com.escmobile.uselessfacts.network

import com.escmobile.uselessfacts.data.Fact
import retrofit2.http.GET
import retrofit2.http.Query

// https://uselessfacts.jsph.pl/random.json?language=en
const val BASE_API_URL = "https://uselessfacts.jsph.pl"
const val GET_FACT = "random.json"

interface UselessFactAPI {
    @GET(GET_FACT)
    suspend fun getFact(@Query("language") lang: String = "en"): Fact
}