package com.example.repo_app_april_2022.domain

import io.reactivex.rxjava3.core.Single

interface GitProjectRepo {

    fun observerReposForUsers(username:String): Single<List<GitProjectEntity>>
}