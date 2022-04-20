package com.example.repo_app_april_2022.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitUserEntity(
    val id: Int,
    val name: String,
    val description: String,
    val avatar_url: String
) : Parcelable


