package com.napptilus.hruiz.willywonka.mainscreen.ui.fragment.adapter

import android.databinding.BindingAdapter
import android.os.Build
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.Glide
import com.napptilus.hruiz.willywonka.R
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Employee
import com.napptilus.hruiz.willywonka.mainscreen.model.entities.Gender
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("employee")
fun loadData(recyclerView: RecyclerView, items: List<Employee>?) {
    with(recyclerView.adapter as MainFragmentAdapter) {
        items?.let { updateData(it) }
    }
}

@BindingAdapter("image")
fun loadImage(circleImageView: CircleImageView, imageUrl: String) {
    Glide.with(circleImageView.context)
        .load(imageUrl)
        .centerInside()
        .placeholder(R.drawable.ic_image_placeholder)
        .into(circleImageView)
}

@BindingAdapter("gender")
fun setColorByGender(constraintLayout: ConstraintLayout, gender: Gender) {
    when (gender) {
        Gender.MALE -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            constraintLayout.setBackgroundColor(constraintLayout.context.getColor(R.color.maleColor))
        else constraintLayout.setBackgroundColor(constraintLayout.resources.getColor(R.color.maleColor))

        Gender.FEMALE -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            constraintLayout.setBackgroundColor(constraintLayout.context.getColor(R.color.femaleColor))
        else constraintLayout.setBackgroundColor(constraintLayout.resources.getColor(R.color.femaleColor))
    }
}
