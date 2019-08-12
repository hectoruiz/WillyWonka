package com.napptilus.hruiz.willywonka.mainscreen.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Employee
import com.napptilus.hruiz.willywonka.mainscreen.model.usecase.GetDepartmentUseCase
import kotlinx.coroutines.*

class MainFragmentViewModel(val getDeparmentUseCase: GetDepartmentUseCase) : ViewModel() {
    private val _employeeList = MutableLiveData<List<Employee>>()
    val employeeList: LiveData<List<Employee>> = _employeeList
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var errorLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isLoading.value = true
        errorLoading.value = false
    }

    private val viewModelJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getEmployees(currentPage: Int) = getEmployeeList(currentPage)

    private fun getEmployeeList(currentPage: Int) {
        scope.launch {
            try {
                _employeeList.value = getDeparmentUseCase.getDepartment(currentPage)?.results
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
                errorLoading.value = true
                Log.d("Exception:", e.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancel()
    }
}
