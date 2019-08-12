package com.napptilus.hruiz.willywonka.mainscreen.model.datasource

import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department
import com.napptilus.hruiz.willywonka.utils.WillyWonkaService
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class DepartmentDataSource(private val service: WillyWonkaService) {
    suspend fun getDepartmentByPageAsync(pageId: Int): Deferred<Response<Department>> =
        withContext(Dispatchers.IO) {
            service.getEmployeeList(pageId)
        }
}