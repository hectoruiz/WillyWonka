package com.napptilus.hruiz.willywonka.mainscreen.model.entities

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id") val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("gender") val gender: Gender,
    @SerializedName("profession") val profession: String,
    @SerializedName("image") val image: String,
    @SerializedName("email") val email: String
)

enum class Gender {
    @SerializedName("M")
    MALE,
    @SerializedName("F")
    FEMALE
}