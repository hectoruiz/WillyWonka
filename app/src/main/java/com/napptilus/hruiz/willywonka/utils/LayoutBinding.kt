package com.napptilus.hruiz.willywonka.utils

import android.databinding.BindingAdapter
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.napptilus.hruiz.willywonka.R
import com.napptilus.hruiz.willywonka.detailscreen.model.entities.EmployeeDetail
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Employee
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Gender
import com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter.MainFragmentAdapter
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("loadingData")
fun loadingData(view: View, dataLoaded: Boolean) {
    Log.d("estado progressbar", dataLoaded.toString())
    when (dataLoaded) {
        true -> view.visibility = View.VISIBLE
        false -> view.visibility = View.GONE
    }
}

@BindingAdapter("employee")
fun loadData(recyclerView: RecyclerView, items: List<Employee>?) {
    with(recyclerView.adapter as MainFragmentAdapter) {
        items?.let { updateData(it) }
    }
}

@BindingAdapter("image")
fun loadImage(circleImageView: CircleImageView, imageUrl: String?) {
    if (imageUrl != null) {
        Glide.with(circleImageView.context)
            .load(imageUrl)
            .centerInside()
            .placeholder(R.drawable.ic_image_placeholder)
            .into(circleImageView)
    }
}

@BindingAdapter("colourGender")
fun setColourByGender(constraintLayout: ConstraintLayout, gender: Gender) {
    when (gender) {
        Gender.MALE -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            constraintLayout.setBackgroundColor(constraintLayout.context.getColor(R.color.maleColor))
        else constraintLayout.setBackgroundColor(constraintLayout.resources.getColor(R.color.maleColor))

        Gender.FEMALE -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            constraintLayout.setBackgroundColor(constraintLayout.context.getColor(R.color.femaleColor))
        else constraintLayout.setBackgroundColor(constraintLayout.resources.getColor(R.color.femaleColor))
    }
}

@BindingAdapter("gender")
fun transFormGender(textView: TextView, gender: Gender?) {
    if (gender != null) {
        when (gender) {
            Gender.FEMALE -> textView.text =
                String.format(textView.context.resources.getString(R.string.employee_gender), "F")
            Gender.MALE -> textView.text =
                String.format(textView.context.resources.getString(R.string.employee_gender), "M")
            else -> textView.text = String.format(textView.context.resources.getString(R.string.employee_gender), "X")
        }
    }
}

@BindingAdapter("errorLoading")
fun showErrorLoading(constraintLayout: ConstraintLayout, error: Boolean) {
    if (error) {
        Snackbar.make(
            constraintLayout.rootView,
            constraintLayout.context.getText(R.string.error_loading),
            Snackbar.LENGTH_LONG
        ).show()
    }
}

@BindingAdapter("showData")
fun showData(view: View, employeeDetail: EmployeeDetail?) {
    when (employeeDetail) {
        null -> view.visibility = View.GONE
        else -> view.visibility = View.VISIBLE
    }
}
