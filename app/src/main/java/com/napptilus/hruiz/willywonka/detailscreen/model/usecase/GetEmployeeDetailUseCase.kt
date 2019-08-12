package com.napptilus.hruiz.willywonka.detailscreen.model.usecase

import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail

interface GetEmployeeDetailUseCase {
    suspend fun getEmployeeDetail(employeeId: Int): EmployeeDetail?
}
