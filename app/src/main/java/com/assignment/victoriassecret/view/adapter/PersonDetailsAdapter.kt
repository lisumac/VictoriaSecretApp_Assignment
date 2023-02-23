package com.assignment.victoriassecret.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.databinding.ProductItemListLayoutBinding
import com.bumptech.glide.Glide


class PersonDetailsAdapter(var productList: ArrayList<Product>): RecyclerView.Adapter<PersonDetailsAdapter.PersonDetailsViewHolder>() {

    class PersonDetailsViewHolder(private val binding: ProductItemListLayoutBinding):RecyclerView.ViewHolder(binding.root){

        @SuppressLint("SetTextI18n")
        fun bind(product: Product) {



            binding.apply {

                tvProductName.text = product.name
                tvProductDetails.text = product.productDesc
                tvProductBrandName.text = product.brand
                tvOfferPrice.text = "\u20B9"+product.offerPrice;

                tvOriginalPrice.text = "\u20B9"+product.price;

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
        val data = productList[position]
        holder.bind(data)

    }

    override fun getItemCount(): Int {
       return  productList.size
    }

    fun sortedList(product_list: ArrayList<Product>) {


        Log.e("TAG", "sortedList: "+product_list.size)

        productList.addAll(product_list)
        val set: Set<Product> = HashSet(productList)
        productList.clear()
        Log.e("TAG", "sortedList4: "+product_list.size )
        productList.addAll(product_list)
        notifyDataSetChanged()
    }
}