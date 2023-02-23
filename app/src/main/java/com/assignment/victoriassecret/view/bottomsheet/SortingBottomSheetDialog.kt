package com.assignment.victoriassecret.view.bottomsheet


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import com.assignment.victoriassecret.R
import com.assignment.victoriassecret.databinding.BottomSheetLayoutBinding
import com.assignment.victoriassecret.databinding.FragmentProductsLayoutBinding
import com.assignment.victoriassecret.utills.BottomSheetSortListner
import com.assignment.victoriassecret.utills.InterfaceListener
import com.assignment.victoriassecret.utills.OnClickListner
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SortingBottomSheetDialog : BottomSheetDialogFragment(),BottomSheetSortListner {
    lateinit var binding: BottomSheetLayoutBinding
    lateinit var getHandlerData_: OnClickListner
    override fun onCreateView(inflater: LayoutInflater, @Nullable container: ViewGroup?, @Nullable savedInstanceState: Bundle?): View? {
        binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
        binding.getHandlerData = getHandlerData_
        onclickListner()
        return binding.root

    }

    private fun onclickListner() {
        binding.tvAscendingOrder.setOnClickListener {
            getHandlerData_.getAscendingOrder()
        }
        binding.tvDescendingOrder.setOnClickListener {
            getHandlerData_.getDescendingOrder()

        }
    }

    override fun ascendingOrder() {
        getHandlerData_.getAscendingOrder()
        dialog?.dismiss()


    }

    override fun descendingOrder() {
        getHandlerData_.getDescendingOrder()
        dialog?.dismiss()
    }
}