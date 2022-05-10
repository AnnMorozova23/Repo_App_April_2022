package com.example.repo_app_april_2022.utils

import com.example.repo_app_april_2022.data.DTO.GitHubRepoDTO
import com.example.repo_app_april_2022.data.DTO.GitHubUserDTO
import com.example.repo_app_april_2022.domain.entity.GitHubRepo
import com.example.repo_app_april_2022.domain.entity.GitHubUser


fun convertGitHubRepoToModel(gitHubRepoList: List<GitHubRepoDTO>): List<GitHubRepo> {
    return gitHubRepoList.map {
        GitHubRepo(it.id, it.name, it.ful_name, it.description)
    }
}

fun convertGitHubUserToModel(gitHubUserList: List<GitHubUserDTO>): List<GitHubUser> {

    return gitHubUserList.map {
        GitHubUser(it.id, it.login, it.avatar_url,it.name)
    }
}