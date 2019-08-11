package com.napptilus.hruiz.willywonka.di

import com.napptilus.hruiz.willywonka.mainscreen.model.datasource.DepartmentDataSource
import com.napptilus.hruiz.willywonka.mainscreen.model.repository.DepartmentRepository
import com.napptilus.hruiz.willywonka.mainscreen.model.repository.impl.DepartmentRepositoryImpl
import com.napptilus.hruiz.willywonka.mainscreen.model.usecase.GetDepartmentUseCase
import com.napptilus.hruiz.willywonka.mainscreen.model.usecase.impl.GetDepartmentUseCaseImpl
import com.napptilus.hruiz.willywonka.mainscreen.viewmodel.MainFragmentViewModel
import com.napptilus.hruiz.willywonka.utils.WillyWonkaService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val departmentModule = module {
    viewModel { provideEmployeesViewModel(get()) }
    factory<GetDepartmentUseCase> { provideGetDepartmentUseCase(get()) }
    single<DepartmentRepository> { provideDepartmentRepository(get()) }
    single { provideDepartmentDataSource(get()) }
}

fun provideEmployeesViewModel(getDepartmentUseCase: GetDepartmentUseCase) = MainFragmentViewModel(getDepartmentUseCase)

fun provideGetDepartmentUseCase(departmentRepository: DepartmentRepository) =
    GetDepartmentUseCaseImpl(departmentRepository)

fun provideDepartmentRepository(departmentDataSource: DepartmentDataSource) =
    DepartmentRepositoryImpl(departmentDataSource)

fun provideDepartmentDataSource(service: WillyWonkaService) = DepartmentDataSource(service)