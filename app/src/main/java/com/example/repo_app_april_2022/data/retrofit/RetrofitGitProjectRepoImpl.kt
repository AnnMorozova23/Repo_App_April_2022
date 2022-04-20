package com.example.repo_app_april_2022.data.retrofit

import com.example.repo_app_april_2022.domain.GitProjectEntity
import com.example.repo_app_april_2022.domain.GitProjectRepo
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitGitProjectRepoImpl : GitProjectRepo {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun observerReposForUsers(username: String): Single<List<GitProjectEntity>> {
        return Single.create { emitter ->
            val call = api.listRepos(username)
            call.enqueue(object : Callback<List<GitProjectEntity>> {
                override fun onResponse(
                    call: Call<List<GitProjectEntity>>,
                    response: Response<List<GitProjectEntity>>
                ) {
                    emitter.onSuccess(response.body())
                }

                override fun onFailure(call: Call<List<GitProjectEntity>>, t: Throwable) {
                    emitter.onError(t)
                }

            })

        }
    }

}

