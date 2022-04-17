package com.example.repo_app_april_2022.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.repo_app_april_2022.domain.GitProjectEntity
import com.example.repo_app_april_2022.domain.GitProjectRepo
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy


class RepoViewModel(private val gitProjectRepo: GitProjectRepo) : ViewModel() {

    private val _repos = MutableLiveData<List<GitProjectEntity>>()
    val repos: LiveData<List<GitProjectEntity>> = _repos
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun onShowRepos(username: String) {
        compositeDisposable.add(gitProjectRepo.observerReposForUsers(username).subscribeBy {
            _repos.postValue(it)
        }
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}