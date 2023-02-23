package com.assignment.victoriassecret.view.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.databinding.ProductDetailsFragmentLayoutBinding
import com.assignment.victoriassecret.utills.Utils
import com.assignment.victoriassecret.viewModel.ProductDetailViewModel

class ProductDetailsFragment : Fragment() {
    private var _binding: ProductDetailsFragmentLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductDetailViewModel by viewModels()

    // private val args: ProductDetailsFragmentArgs by navArgs()
    lateinit var product: Product

    companion object {
        val REQUEST_KEY = "101"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ProductDetailsFragmentLayoutBinding.inflate(inflater, container, false)
        getDataFromBundle()
        return binding.root
    }

    private fun getDataFromBundle() {
        val args = arguments
        val personJsonString = args!!.getString("PRODUCT_DETAIL")
        product = Utils.getGsonParser()!!.fromJson(personJsonString, Product::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUiData()


    }

    private fun setupUiData() {

        binding.tvProductDetails.text = product.productDesc
        binding.tvProductDetailsBrand.text = product.brand
        binding.tvProductDetailsName.text = product.name

        binding.ivProductDetailsImage.load(product.productUrl) {
            crossfade(true)
            crossfade(1000)
        }
    }
}