package com.codegalaxy.mock21nov

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
):Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        if(!NetworkUtils.isInternetAvailable(context))
        {
            throw NoInternetConnectionException("No internet connection")
        }

        return chain.proceed(chain.request())
    }
}

class NoInternetConnectionException(message:String):IOException(message)