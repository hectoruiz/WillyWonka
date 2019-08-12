package com.napptilus.hruiz.willywonka.detailscreen.model.datasource

import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import com.napptilus.hruiz.willywonka.utils.WillyWonkaService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class EmployeeDetailDataSource(private val service: WillyWonkaService) {
    suspend fun getEmployeeDetailByIdAsync(employeeId: Int): Deferred<Response<EmployeeDetail>> =
        withContext(Dispatchers.IO) {
            service.getEmployeeDetail(employeeId)
        }
}
