package com.napptilus.hruiz.willywonka.mainscreen.model.usecase

import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Department

interface GetDepartmentUseCase {
    suspend fun getDepartment(currentPage: Int): Department?
}
