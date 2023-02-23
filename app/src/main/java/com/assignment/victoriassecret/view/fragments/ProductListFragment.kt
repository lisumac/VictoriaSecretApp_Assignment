package com.assignment.victoriassecret.view.fragments


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.assignment.victoriassecret.R
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.databinding.FragmentProductsLayoutBinding
import com.assignment.victoriassecret.utills.ItemOnClickListner
import com.assignment.victoriassecret.utills.OnClickListner
import com.assignment.victoriassecret.utills.Utils
import com.assignment.victoriassecret.utills.toast
import com.assignment.victoriassecret.view.adapter.PersonDetailsAdapter
import com.assignment.victoriassecret.view.bottomsheet.SortingBottomSheetDialog
import com.assignment.victoriassecret.viewModel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class ProductListFragment : Fragment(), OnClickListner, ItemOnClickListner {
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
        binding.progressBar.visibility = View.VISIBLE
        setupUiData()

        onclickListner()
    }

    private fun onclickListner() {
        binding.tvSortItem.setOnClickListener {

            val bottomSheet = SortingBottomSheetDialog()
            bottomSheet.show(requireFragmentManager(), "Sort")
            bottomSheet.getHandlerData_ = this
        }

        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input

                // adapter.filter.filter(editable.toString())
                filter(editable.toString())
            }
        })


    }

    private fun setupUiData() {
        binding.progressBar.visibility = View.GONE


        viewModel.productsLiveData.observe(requireActivity()) { result ->
            if (result.isNotEmpty()) {
                adapter = PersonDetailsAdapter(result as ArrayList<Product>)
                adapter.onItemOnClickListner = this
                binding.rvProductList.adapter = adapter;
                productList = result

            }

        }


    }

    private fun filter(text: String) {
        //new array list that will hold the filtered data
        val filterdNames: ArrayList<Product> = ArrayList()
        for (s in productList) {
            //if the existing elements contains the search input
            if (s.name.lowercase(Locale.getDefault())
                    .contains(text.lowercase(Locale.getDefault()))
            ) {
                //adding the element to filtered list
                filterdNames.add(s)
            }
        }


        adapter.filterList(filterdNames)
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

    override fun itemClick(product: Product) {

        Log.e("TAG", "itemClick: $product")
        requireActivity().toast(product.name)
        /*val action = ProductListFragmentDirections.actionProductListToDetailFragment(product)
        findNavController().navigateUp()
        findNavController().navigate(action)*/


    }


}