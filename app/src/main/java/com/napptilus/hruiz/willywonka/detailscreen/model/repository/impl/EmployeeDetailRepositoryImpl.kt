package com.napptilus.hruiz.willywonka.detailscreen.model.repository.impl

import com.napptilus.hruiz.willywonka.detailscreen.model.datasource.EmployeeDetailDataSource
import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import kotlinx.coroutines.Deferred
import retrofit2.Response

class EmployeeDetailRepositoryImpl(
    private val employeeDetailDataSource: EmployeeDetailDataSource
) : EmployeeDetailRepository {
    override suspend fun getEmployeeDetailAsync(employeeId: Int): Deferred<Response<EmployeeDetail>> =
        employeeDetailDataSource.getEmployeeDetailByIdAsync(employeeId)
}
