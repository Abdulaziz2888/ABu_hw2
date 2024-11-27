package com.example.abu_hw2.data

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApiService {

    @GET("getPercentage")
    fun getPercentage(
        @Header("X-Rapidapi-Key") key: String,
        @Header("X-RapiDapi-Host") host: String,
        @Query("fname") firstName: String,
        @Query("sname") secondName: String
    ): retrofit2.Call<LoveResult>
}