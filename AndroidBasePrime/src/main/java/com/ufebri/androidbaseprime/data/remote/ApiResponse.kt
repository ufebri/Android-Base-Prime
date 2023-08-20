package com.ufebri.androidbaseprime.data.remote

/**
 * Created by Uray Febri on 05/01/2022.
 */
sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorMessage: String) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}