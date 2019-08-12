package com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.napptilus.hruiz.willywonka.databinding.ItemMainFragmentBinding
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Employee
import com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter.listener.OnClickEmployeeListener
import com.napptilus.hruiz.willywonka.mainscreen.viewmodel.MainFragmentViewModel
import java.lang.ref.WeakReference

class MainFragmentViewHolder(
    view: View,
    onEmployeeClickListener: WeakReference<OnClickEmployeeListener>?
) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMainFragmentBinding.bind(view)
    private val onClickEmployeeListener: WeakReference<OnClickEmployeeListener>? = onEmployeeClickListener

    fun bindTo(employee: Employee, viewModel: Lazy<MainFragmentViewModel>) {
        binding.employee = employee

        itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onClickEmployeeListener?.get()?.onEmployeeListItemClicked(employee.id)
            }
        })
    }
}