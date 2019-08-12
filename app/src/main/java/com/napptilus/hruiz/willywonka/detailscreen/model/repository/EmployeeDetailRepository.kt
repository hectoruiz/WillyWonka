package com.napptilus.hruiz.willywonka.detailscreen.model.repository.impl

import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface EmployeeDetailRepository {
    suspend fun getEmployeeDetailAsync(employeeId: Int): Deferred<Response<EmployeeDetail>>
}
