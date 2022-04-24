package com.example.repo_app_april_2022.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubAvatarUser(
    val user: User,
    val avatar_url:String
):Parcelable
