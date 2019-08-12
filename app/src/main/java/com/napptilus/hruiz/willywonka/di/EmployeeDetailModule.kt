package com.napptilus.hruiz.willywonka.di

import com.napptilus.hruiz.willywonka.detailscreen.model.datasource.EmployeeDetailDataSource
import com.napptilus.hruiz.willywonka.detailscreen.model.repository.impl.EmployeeDetailRepository
import com.napptilus.hruiz.willywonka.detailscreen.model.repository.impl.EmployeeDetailRepositoryImpl
import com.napptilus.hruiz.willywonka.detailscreen.model.usecase.GetEmployeeDetailUseCase
import com.napptilus.hruiz.willywonka.detailscreen.model.usecase.impl.GetEmployeeDetailUseCaseImpl
import com.napptilus.hruiz.willywonka.detailscreen.viewmodel.DetailFragmentViewModel
import com.napptilus.hruiz.willywonka.utils.WillyWonkaService
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val employeeDetailModule = module {
    viewModel { provideEmployeesDetailViewModel(get()) }
    factory<GetEmployeeDetailUseCase> { provideGetEmployeeDetailUseCase(get()) }
    single<EmployeeDetailRepository> { provideEmployeeDetailRepository(get()) }
    single { provideEmployeeDetailDataSource(get()) }
}

fun provideEmployeesDetailViewModel(employeeDetailUseCase: GetEmployeeDetailUseCase) =
    DetailFragmentViewModel(employeeDetailUseCase)

fun provideGetEmployeeDetailUseCase(employeeDetailRepository: EmployeeDetailRepository) =
    GetEmployeeDetailUseCaseImpl(employeeDetailRepository)

fun provideEmployeeDetailRepository(employeeDetailDataSource: EmployeeDetailDataSource) =
    EmployeeDetailRepositoryImpl(employeeDetailDataSource)

fun provideEmployeeDetailDataSource(service: WillyWonkaService) = EmployeeDetailDataSource(service)