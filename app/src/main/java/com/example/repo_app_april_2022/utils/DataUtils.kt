package com.example.repo_app_april_2022.utils

import com.example.repo_app_april_2022.domain.GitHubAvatarUser
import com.example.repo_app_april_2022.domain.GitHubUser


fun convertGitProjectEntityToModel(gitUser: GitHubAvatarUser): GitHubUser {
    return GitHubUser(
        gitUser.user.id,
        gitUser.user.login,
        gitUser.user.description,
        gitUser.user.name,
        gitUser.avatar_url
    )
}