package com.assignment.victoriassecret.view.adapter

import android.graphics.Paint
import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


object BindAdapter {


    @JvmStatic
    @BindingAdapter("productImage")
    fun loadImage(view: ImageView, imageUrl: String) {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("strikeThrough")
    fun strikeThrough(textView: TextView, strikeThrough: Boolean) {
        if (strikeThrough) {
            textView.paintFlags = textView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            textView.paintFlags = textView.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

}