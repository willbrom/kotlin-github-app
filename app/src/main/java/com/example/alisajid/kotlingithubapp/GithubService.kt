package com.example.alisajid.kotlingithubapp

import com.example.alisajid.kotlingithubapp.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{path}")
    fun getUser(@Path("path") path: String): Call<User>
}