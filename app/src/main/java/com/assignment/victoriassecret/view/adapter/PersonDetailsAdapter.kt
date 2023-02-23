package com.assignment.victoriassecret.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.databinding.ProductItemListLayoutBinding
import com.assignment.victoriassecret.utills.ItemOnClickListner
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList


class PersonDetailsAdapter(var productList: ArrayList<Product>) :
    RecyclerView.Adapter<PersonDetailsAdapter.PersonDetailsViewHolder>() {
    lateinit var onItemOnClickListner: ItemOnClickListner
    private var filteredProductNameList: List<Product>? = null

    class PersonDetailsViewHolder(private val binding: ProductItemListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {


            binding.apply {

                tvProductName.text = product.name
                tvProductDetails.text = product.productDesc
                tvProductBrandName.text = product.brand
                tvOfferPrice.text = "\u20B9" + product.offerPrice;

                tvOriginalPrice.text = "\u20B9" + product.price;

                Glide.with(ivProduct.context)
                    .load(product.productUrl)
                    .into(ivProduct)

            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonDetailsViewHolder {

        val binding =
            ProductItemListLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonDetailsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonDetailsViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)

        holder.itemView.setOnClickListener { mview ->

            /* val action = ProductListFragmentDirections.actionProductListToDetailFragment(product)

             mview.findNavController().navigate(action)*/
            onItemOnClickListner.itemClick(product)
        }


    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun sortedList(product_list: ArrayList<Product>) {

        this.productList = product_list
        notifyDataSetChanged()
    }


    fun filterList(filterdNames: ArrayList<Product>) {

        this.productList = filterdNames;
        notifyDataSetChanged();
    }
}