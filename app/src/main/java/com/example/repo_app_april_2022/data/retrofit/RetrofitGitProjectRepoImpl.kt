package com.example.repo_app_april_2022.data.retrofit
import com.example.repo_app_april_2022.domain.entity.GitHubUser
import com.example.repo_app_april_2022.domain.GitProjectRepo
import com.example.repo_app_april_2022.domain.entity.GitHubRepo
import com.example.repo_app_april_2022.utils.convertGitHubRepoToModel
import com.example.repo_app_april_2022.utils.convertGitHubUserToModel
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitGitProjectRepoImpl : GitProjectRepo {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getUserRepositories(username: String): Single<List<GitHubUser>> {
        return api.listRepos(username)

    }

    override fun getGitHubUser(name:String): Single<List<GitHubUser>> {
        return api.listGitHubUser(name).map { convertGitHubUserToModel(it) }
    }

    override fun getGitHubRepo(name:String): Single<List<GitHubRepo>> {
        return api.listGitHubRepos(name).map { convertGitHubRepoToModel(it) }
    }


}