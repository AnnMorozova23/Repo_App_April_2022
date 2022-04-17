package com.example.repo_app_april_2022.data

import com.example.repo_app_april_2022.R
import com.example.repo_app_april_2022.domain.GitProjectEntity
import com.example.repo_app_april_2022.domain.GitProjectRepo
import io.reactivex.rxjava3.core.Single

class MockGitProjectRepoImpl:GitProjectRepo {
    override fun observerReposForUsers(username: String): Single<List<GitProjectEntity>> {
        val testList = listOf(
            GitProjectEntity(1, "Test1", "R.drawable.cat_3"),
            GitProjectEntity(2, "Test2","R.drawable.cat_3"),
            GitProjectEntity(3, "Test3","R.drawable.cat_3"),
            GitProjectEntity(4, "Test4","R.drawable.cat_3"),
            GitProjectEntity(5, "Test5","R.drawable.cat_3"),
        )
        return Single.just(testList)
    }
}