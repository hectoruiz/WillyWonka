package com.napptilus.hruiz.willywonka.mainscreen.model.repository

import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department
import kotlinx.coroutines.Deferred
import retrofit2.Response

interface DepartmentRepository {
    suspend fun getEmployeeListAsync(currentPage: Int, maxPage: Int): Deferred<Response<Department>>
}