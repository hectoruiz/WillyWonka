package com.napptilus.hruiz.willywonka.detailscreen.model.entities

import com.google.gson.annotations.SerializedName
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Gender

data class EmployeeDetail(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("age") val age: Int,
    @SerializedName("image") val image: String,
    @SerializedName("gender") val gender: Gender,
    @SerializedName("country") val country: String,
    @SerializedName("profession") val profession: String,
    @SerializedName("height") val height: Int,
    @SerializedName("favorite") val favorite: Favorite,
    @SerializedName("description") val description: String,
    @SerializedName("quota") val quota: String
)

