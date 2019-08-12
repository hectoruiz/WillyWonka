package com.napptilus.hruiz.willywonka.mainscreen.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import com.napptilus.hruiz.willywonka.databinding.MainFragmentBinding
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Gender
import com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter.MainFragmentAdapter
import com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter.listener.OnClickEmployeeListener
import com.napptilus.hruiz.willywonka.mainscreen.viewmodel.MainFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment(),
    OnClickEmployeeListener {
    private val mainFragmentViewModel: MainFragmentViewModel by viewModel()
    private lateinit var binding: MainFragmentBinding
    private lateinit var adapter: MainFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = mainFragmentViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MainFragmentAdapter(viewModel())
        adapter.setOnClickListener(this)
        bindViews()

        if (mainFragmentViewModel.employeeList.value == null) mainFragmentViewModel.getEmployees(1)
    }

    override fun onEmployeeListItemClicked(idEmployee: Int) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment()
        action.employeeId = idEmployee

        findNavController().navigate(action)
    }

    private fun bindViews() {
        binding.rvEmployees.adapter = this.adapter
        binding.svProfession.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.employeesFilter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapter.employeesFilter.filter(query)
                return false
            }
        })
        binding.cbMale.setOnCheckedChangeListener { _, isChecked ->
            adapter.genderFilter(
                isChecked,
                Gender.MALE
            )
        }

        binding.cbFemale.setOnCheckedChangeListener { _, isChecked ->
            adapter.genderFilter(
                isChecked,
                Gender.FEMALE
            )
        }
    }
}
