package com.example.repo_app_april_2022.data.retrofit

import com.example.repo_app_april_2022.domain.GitHubUser
import com.example.repo_app_april_2022.domain.GitProjectRepo
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitGitProjectRepoImpl : GitProjectRepo {

        private val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    private val api: GitHubApi = retrofit.create(GitHubApi::class.java)

    override fun getUserRepositories(username: String): Single<List<GitHubUser>> {
        return Single.create { emitter ->
            val call = api.listRepos(username)
            call.enqueue(object : Callback<List<GitHubUser>> {
                override fun onResponse(
                    call: Call<List<GitHubUser>>,
                    response: Response<List<GitHubUser>>
                ) {
                    response.body()?.let { emitter.onSuccess(it) }
                }

                override fun onFailure(call: Call<List<GitHubUser>>, t: Throwable) {
                    emitter.onError(t)
                }

            })

        }
    }

}

