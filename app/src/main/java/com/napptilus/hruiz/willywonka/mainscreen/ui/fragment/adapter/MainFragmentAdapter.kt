package com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import com.napptilus.hruiz.willywonka.R
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Employee
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Gender
import com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter.listener.OnClickEmployeeListener
import com.napptilus.hruiz.willywonka.mainscreen.viewmodel.MainFragmentViewModel
import java.lang.ref.WeakReference

class MainFragmentAdapter(
    private val viewModel: Lazy<MainFragmentViewModel>
) :
    RecyclerView.Adapter<MainFragmentViewHolder>(), Filterable {

    private var employees: List<Employee>
    private var allEmployees: List<Employee>
    private var employeeListFiltered: MutableList<Employee>
    private var filterMaleActivated: Boolean
    private var filterFemaleActivated: Boolean
    private var onEmployeeClickListener: WeakReference<OnClickEmployeeListener>? = null

    init {
        employees = mutableListOf()
        allEmployees = mutableListOf()
        employeeListFiltered = mutableListOf()
        filterMaleActivated = false
        filterFemaleActivated = false
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MainFragmentViewHolder =
        MainFragmentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_main_fragment, parent, false), onEmployeeClickListener
        )

    fun setOnClickListener(onClickListener: OnClickEmployeeListener) {
        onEmployeeClickListener = WeakReference(onClickListener)
    }

    override fun getItemCount(): Int = employees.size

    override fun onBindViewHolder(holder: MainFragmentViewHolder, position: Int) {
        holder.bindTo(employees[position], viewModel)
    }

    override fun getFilter(): Filter {
        return employeesFilter
    }

    fun updateData(employeeList: List<Employee>) {
        employees = employeeList
        allEmployees = employeeList
        notifyDataSetChanged()
    }

    val employeesFilter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val charSequenceString = charSequence.toString()
            if (stateOfBothGendersFilterActivated()) employees = allEmployees
            if (charSequenceString.isEmpty()) {
                employees = allEmployees
                employeeListFiltered = mutableListOf()
            } else if (charSequenceString.isEmpty().not()) {
                employeeListFiltered = mutableListOf()
                allEmployees.map {
                    if (it.profession.toLowerCase().startsWith(charSequenceString.toLowerCase())
                        || it.profession.toLowerCase().contains(charSequenceString.toLowerCase())
                    )
                        employeeListFiltered.add(it)
                }
                employees = employeeListFiltered
            }

            val filterResults = FilterResults()
            filterResults.values = employees
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (stateOfBothGendersFilterActivated().not()) applyGenderFilters()
            notifyDataSetChanged()
        }
    }

    fun genderFilter(checked: Boolean, gender: Gender) {
        when (gender) {
            Gender.MALE -> filterMaleActivated = checked
            Gender.FEMALE -> filterFemaleActivated = checked
        }
        applyGenderFilters()
    }

    private fun applyGenderFilters() {
        if (employeeListFiltered.size > 0) employeeListFiltered.run {
            val genderFilterEmployeeFilteredList: MutableList<Employee> = mutableListOf()
            genderFilterEmployeeFilteredList.addAll(employeeListFiltered)

            if (stateOfBothGendersFilterActivated()) {
                employees = employeeListFiltered
            } else if (isMaleGenderFilterActivated()) {
                employeeListFiltered.map {
                    if (it.gender == Gender.FEMALE)
                        genderFilterEmployeeFilteredList.remove(it)
                }
                employees = genderFilterEmployeeFilteredList
            } else if (!isMaleGenderFilterActivated()) {
                employeeListFiltered.map {
                    if (it.gender == Gender.MALE)
                        genderFilterEmployeeFilteredList.remove(it)
                }
                employees = genderFilterEmployeeFilteredList
            }
        }
        else employees.run {
            val genderFilterEmployeeList: MutableList<Employee> = mutableListOf()
            genderFilterEmployeeList.addAll(employees)

            if (stateOfBothGendersFilterActivated()) {
                employees = allEmployees
            } else if (isMaleGenderFilterActivated()) {
                employees.map {
                    if (it.gender == Gender.FEMALE)
                        genderFilterEmployeeList.remove(it)
                }
                employees = genderFilterEmployeeList
            } else if (!isMaleGenderFilterActivated()) {
                employees.map {
                    if (it.gender == Gender.MALE)
                        genderFilterEmployeeList.remove(it)
                }
                employees = genderFilterEmployeeList
            }
        }
        notifyDataSetChanged()
    }

    private fun stateOfBothGendersFilterActivated() = ((filterMaleActivated && filterFemaleActivated)
            || (!filterMaleActivated && !filterFemaleActivated))

    private fun isMaleGenderFilterActivated() = filterMaleActivated
}