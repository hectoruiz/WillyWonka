package com.napptilus.hruiz.willywonka.detailscreen.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.napptilus.hruiz.willywonka.databinding.DetailFragmentBinding
import com.napptilus.hruiz.willywonka.detailscreen.viewmodel.DetailFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class DetailFragment : Fragment() {
    private val detailFragmentViewModel: DetailFragmentViewModel by viewModel()
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        binding = DetailFragmentBinding.inflate(inflater, container, false)
        binding.viewmodel = detailFragmentViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews()

        val idEmployee = arguments?.let { it -> DetailFragmentArgs.fromBundle(it).employeeId }

        idEmployee?.let { detailFragmentViewModel.getEmployee(it) }
    }

    private fun bindViews() {
    }
}
