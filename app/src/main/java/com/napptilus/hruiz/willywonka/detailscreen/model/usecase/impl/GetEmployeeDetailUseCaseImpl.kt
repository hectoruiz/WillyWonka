package com.napptilus.hruiz.willywonka.detailscreen.model.usecase.impl

import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import com.napptilus.hruiz.willywonka.detailscreen.model.repository.impl.EmployeeDetailRepository
import com.napptilus.hruiz.willywonka.detailscreen.model.usecase.GetEmployeeDetailUseCase

class GetEmployeeDetailUseCaseImpl(private val employeeDetailRepository: EmployeeDetailRepository) :
    GetEmployeeDetailUseCase {
    override suspend fun getEmployeeDetail(employeeId: Int): EmployeeDetail? =
        executeGetEmployeeDetailUseCaseAsync(employeeId)

    private suspend fun executeGetEmployeeDetailUseCaseAsync(employeeId: Int) =
        employeeDetailRepository.getEmployeeDetailAsync(employeeId).await().body()
}