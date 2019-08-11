package com.napptilus.hruiz.willywonka.mainscreen.model.entities

import com.google.gson.annotations.SerializedName

data class Department(
    @SerializedName("current") val current: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("results") val results: List<Employee>?
)


