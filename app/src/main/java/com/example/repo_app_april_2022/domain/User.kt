package com.example.repo_app_april_2022.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int,
    val login: String,
    val description:String,
    val name: String
): Parcelable