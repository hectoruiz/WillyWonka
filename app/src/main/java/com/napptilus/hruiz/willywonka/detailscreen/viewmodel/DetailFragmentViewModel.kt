package com.napptilus.hruiz.willywonka.detailscreen.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import com.napptilus.hruiz.willywonka.detailscreen.model.usecase.GetEmployeeDetailUseCase
import kotlinx.coroutines.*

class DetailFragmentViewModel constructor(private val getEmployeeDetailUseCase: GetEmployeeDetailUseCase) :
    ViewModel() {

    private val _employeeDetail = MutableLiveData<EmployeeDetail>()
    val employeeDetail: LiveData<EmployeeDetail> = _employeeDetail
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    var errorLoading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isLoading.value = true
        errorLoading.value = false
    }

    private val viewModelJob = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun getEmployee(employeeId: Int) = getEmployeeDetail(employeeId)

    private fun getEmployeeDetail(employeeId: Int) {
        scope.launch {
            try {
                _employeeDetail.value = getEmployeeDetailUseCase.getEmployeeDetail(employeeId)
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