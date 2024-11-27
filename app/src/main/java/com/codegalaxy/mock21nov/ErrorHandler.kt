package com.codegalaxy.mock21nov

object ErrorHandler {

    fun  getErrorMessage(throwable: Throwable): String{
        return when(throwable){
            is NoInternetConnectionException -> "No internet connection ${throwable.localizedMessage}"
            else -> "Something else error"
        }
    }
}