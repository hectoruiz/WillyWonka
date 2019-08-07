package com.napptilus.hruiz.willywonka.utils

import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WillyWonkaApi {
    @GET("oompa-loompas")
    fun getEmployeeList(@Query("page") id: Int): Deferred<Response<List<Department>>>

    @GET("oompa-loompas/{id}")
    fun getEmployeeDetail(@Path("id") employeeId: Int): Deferred<Response<EmployeeDetail>>
}
