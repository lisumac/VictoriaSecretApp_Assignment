package com.assignment.victoriassecret.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.databinding.FragmentProductsLayoutBinding
import com.assignment.victoriassecret.utills.OnClickListner
import com.assignment.victoriassecret.view.adapter.PersonDetailsAdapter
import com.assignment.victoriassecret.view.adapter.ProductListAdapter
import com.assignment.victoriassecret.view.bottomsheet.SortingBottomSheetDialog
import com.assignment.victoriassecret.viewModel.ProductListViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductListFragment : Fragment(), OnClickListner {
    private var _binding: FragmentProductsLayoutBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductListViewModel by viewModels()
    private lateinit var adapter: PersonDetailsAdapter
    var productList: ArrayList<Product> = ArrayList<Product>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUiData()

        onclickListner()
    }

    private fun onclickListner() {
        binding.tvSortItem.setOnClickListener {
            // allHistoryList.sortByDescending { list -> list.size }

            val bottomSheet = SortingBottomSheetDialog()
            bottomSheet.show(requireFragmentManager(), "Sort")
            bottomSheet.getHandlerData_ = this
        }
    }

    private fun setupUiData() {
        binding.progressBar.visibility = View.GONE


        viewModel.productsLiveData.observe(requireActivity()) { result ->
            if (result.isNotEmpty()){
                adapter = PersonDetailsAdapter( result as ArrayList<Product>)
                binding.rvProductList.adapter = adapter;
                productList = result as ArrayList<Product>

            }

        }


    }

    override fun getAscendingOrder() {
        productList.sortWith(
            compareBy(String.CASE_INSENSITIVE_ORDER) { it.name }
        )
      adapter.sortedList(productList)
    }

    override fun getDescendingOrder() {
        productList.sortByDescending { it.name }
        adapter.sortedList(productList)

    }

}