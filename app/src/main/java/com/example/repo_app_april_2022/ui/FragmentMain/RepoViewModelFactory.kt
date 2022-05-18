package com.example.repo_app_april_2022.ui.FragmentMain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.repo_app_april_2022.domain.GitProjectRepo


class RepoViewModelFactory(private val repo: GitProjectRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RepoViewModel(repo) as T
    }
}