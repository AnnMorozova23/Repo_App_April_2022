package com.example.repo_app_april_2022.data.retrofit

import com.example.repo_app_april_2022.domain.GitHubUser

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Call<List<GitHubUser>>


}
