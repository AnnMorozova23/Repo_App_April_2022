package com.example.repo_app_april_2022.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubRepo(
    val id: Int,
    val name: String,
    val fulName:String,
    val description:String
):Parcelable
