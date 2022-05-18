package com.example.repo_app_april_2022

import android.app.Application
import android.content.Context
import com.example.repo_app_april_2022.data.retrofit.RetrofitGitProjectRepoImpl
import com.example.repo_app_april_2022.domain.GitProjectRepo

class App : Application() {
    val gitProjectRepo: GitProjectRepo by lazy { RetrofitGitProjectRepoImpl() }
}

val Context.app: App
    get() = applicationContext as App