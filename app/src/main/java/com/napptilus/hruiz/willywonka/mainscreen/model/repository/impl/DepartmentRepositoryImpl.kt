package com.napptilus.hruiz.willywonka.mainscreen.model.repository.impl

import com.napptilus.hruiz.willywonka.mainscreen.model.datasource.DepartmentDataSource
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department
import com.napptilus.hruiz.willywonka.mainscreen.model.repository.DepartmentRepository
import kotlinx.coroutines.Deferred
import retrofit2.Response

class DepartmentRepositoryImpl(private val departmentDataSource: DepartmentDataSource) : DepartmentRepository {
    override suspend fun getEmployeeListAsync(currentPage: Int, maxPage: Int): Deferred<Response<Department>> {
        return departmentDataSource.getDepartmentByPageAsync(currentPage)
    }
}