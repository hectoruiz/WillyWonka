package com.napptilus.hruiz.willywonka.utils

import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department
import kotlinx.coroutines.Deferred
import retrofit2.Response

class WillyWonkaService(private val api: WillyWonkaApi) {
    fun getEmployeeList(currentPage: Int): Deferred<Response<Department>> = api.getEmployeeList(currentPage)

    fun getEmployeeDetail(employeeId: Int): Deferred<Response<EmployeeDetail>> = api.getEmployeeDetail(employeeId)
}