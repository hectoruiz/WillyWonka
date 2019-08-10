package com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.napptilus.hruiz.willywonka.databinding.ItemMainFragmentBinding
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Employee
import com.napptilus.hruiz.willywonka.mainscreen.viewmodel.MainFragmentViewModel

class MainFragmentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMainFragmentBinding.bind(view)

    fun bindTo(employee: Employee, viewModel: Lazy<MainFragmentViewModel>) {
        binding.employee = employee
        binding.viewmodel = viewModel.value
    }
}