package com.escmobile.uselessfacts.di.modules
import com.escmobile.uselessfacts.data.FactRepo
import com.escmobile.uselessfacts.network.BASE_API_URL
import com.escmobile.uselessfacts.network.FactInterceptor
import com.escmobile.uselessfacts.network.UselessFactAPI
import com.escmobile.uselessfacts.ui.viewmodels.UselessFactViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    single { UselessFactViewModel(get()) }
}

val repoModule = module {
    single{FactRepo(get()) }
}

val apiModule = module {
    single<UselessFactAPI> {

        val builder = Retrofit.Builder()
            .baseUrl(BASE_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

        builder.create(UselessFactAPI::class.java)
    }
}

val factInterceptorModule = module {
    single<FactInterceptor> { FactInterceptor() }
}