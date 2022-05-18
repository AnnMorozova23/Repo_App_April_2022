package com.example.repo_app_april_2022.domain.entity
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    val id: Int,
    val login: String?,
    val avatarUrl: String?,
    val name: String
) : Parcelable

