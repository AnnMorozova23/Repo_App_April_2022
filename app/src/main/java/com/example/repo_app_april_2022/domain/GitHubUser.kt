package com.example.repo_app_april_2022.domain

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    @Expose val id: Int,
    @Expose val login: String,
    @Expose val description: String,
    @Expose val name: String,
    @Expose val avatarUrl: String
) : Parcelable

