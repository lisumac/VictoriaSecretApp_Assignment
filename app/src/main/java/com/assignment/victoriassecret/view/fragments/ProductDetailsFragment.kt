package com.assignment.victoriassecret.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.assignment.victoriassecret.databinding.ProductDetailsFragmentLayoutBinding
import com.assignment.victoriassecret.viewModel.ProductDetailViewModel

class ProductDetailsFragment: Fragment() {
    private var _binding: ProductDetailsFragmentLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProductDetailsFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUiData()


    }

    private fun setupUiData() {


    }
}