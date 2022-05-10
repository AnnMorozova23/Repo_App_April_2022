package com.example.repo_app_april_2022.data.retrofit

import com.example.repo_app_april_2022.data.DTO.GitHubRepoDTO
import com.example.repo_app_april_2022.data.DTO.GitHubUserDTO
import com.example.repo_app_april_2022.domain.entity.GitHubRepo
import com.example.repo_app_april_2022.domain.entity.GitHubUser
import io.reactivex.rxjava3.core.Single

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GitHubApi {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String?): Single<List<GitHubUser>>

    @GET("users/{user}/repos")
    fun listGitHubRepos(@Path("user") user:String?):Single<List<GitHubRepoDTO>>

    @GET("users/{user}/repos")
    fun listGitHubUser(@Path("user") user:String?):Single<List<GitHubUserDTO>>


}
