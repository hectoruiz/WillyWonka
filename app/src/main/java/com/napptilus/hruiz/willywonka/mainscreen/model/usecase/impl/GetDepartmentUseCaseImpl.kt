package com.napptilus.hruiz.willywonka.mainscreen.model.usecase.impl

import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department
import com.napptilus.hruiz.willywonka.mainscreen.model.repository.DepartmentRepository
import com.napptilus.hruiz.willywonka.mainscreen.model.usecase.GetDepartmentUseCase

class GetDepartmentUseCaseImpl(private val departmentRepository: DepartmentRepository) :
    GetDepartmentUseCase {
    override suspend fun getDepartment(currentPage: Int): Department? =
        executeGetEmployeeDetailUseCaseAsync(currentPage)

    private suspend fun executeGetEmployeeDetailUseCaseAsync(currentPage: Int): Department? =
        departmentRepository.getEmployeeListAsync(currentPage, 20).await().body()
}