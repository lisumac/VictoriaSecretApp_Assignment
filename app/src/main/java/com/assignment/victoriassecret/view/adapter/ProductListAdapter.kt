package com.assignment.victoriassecret.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.databinding.ProductItemListLayoutBinding
import com.bumptech.glide.Glide

class ProductListAdapter()  {

   /* adapter = PersonDetailsAdapter( it)
    binding.rvProductList.adapter = adapter;*/
    /*var productList: List<Product> = ArrayList<Product>()

    inner class RecipeViewHolder(val binding: ProductItemListLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    *//*   private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }


    }*//*

    //  private val differ = AsyncListDiffer(this, diffCallback)

    *//*var productList: List<Product>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }*//*

    fun getList(products: List<Product>) {
        this.productList = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(
            ProductItemListLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val product = productList[position]

        holder.binding.apply {

            tvProductName.text = product.name
            tvProductDetails.text = product.productDesc
            tvProductBrandName.text = product.brand

            Glide.with(ivProduct.context)
                .load(product.productUrl)
                .into(ivProduct)

        }

        *//* holder.itemView.setOnClickListener { mView->
             val direction = HomeFragmentDirections
                 .actionHomeFragment2ToDetailFragment2(currRecipe)
             mView.findNavController().navigate(direction)
         }*//*

    }

    override fun getItemCount() = productList.size*/

}