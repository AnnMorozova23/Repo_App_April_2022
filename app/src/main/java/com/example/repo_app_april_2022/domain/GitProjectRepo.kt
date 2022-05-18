package com.example.repo_app_april_2022.domain


import com.example.repo_app_april_2022.domain.entity.GitHubRepo
import com.example.repo_app_april_2022.domain.entity.GitHubUser
import io.reactivex.rxjava3.core.Single

interface GitProjectRepo {

    fun getUserRepositories(username:String): Single<List<GitHubUser>>

    fun getGitHubUser(name: String):Single<List<GitHubUser>>

    fun getGitHubRepo(name:String):Single<List<GitHubRepo>>
}