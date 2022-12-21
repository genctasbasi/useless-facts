package com.escmobile.uselessfacts

import android.app.Application
import com.escmobile.uselessfacts.di.modules.apiModule
import com.escmobile.uselessfacts.di.modules.factInterceptorModule
import com.escmobile.uselessfacts.di.modules.repoModule
import com.escmobile.uselessfacts.di.modules.viewModelModule
import org.koin.core.context.startKoin

class UselessFactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {

        startKoin {
            applicationContext
            modules(
                listOf(
                    viewModelModule,
                    repoModule,
                    apiModule,
                    factInterceptorModule
                )
            )
        }
    }
}