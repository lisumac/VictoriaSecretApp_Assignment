package com.assignment.victoriassecret.utills

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.assignment.victoriassecret.data.dataModel.Product
import com.google.android.material.textfield.TextInputEditText


fun Context.toast(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_LONG
    ).show()
}

fun Context.showKeyBoard(searchView: TextInputEditText) {
    searchView.apply {
        text = null
        requestFocus()
        val imm =
            this@showKeyBoard.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }

}

fun Activity.hideSoftKeyboard() {
    val view = this.currentFocus
    view?.let {
        val imm =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    fun getAscendingOrder(product_list: ArrayList<Product>) {
        product_list.sortWith(
            compareBy(String.CASE_INSENSITIVE_ORDER) { it.name }
        )

    }

    fun getDescendingOrder(product_list: ArrayList<Product>): ArrayList<Product> {
        var productlist: ArrayList<Product> = ArrayList()
        product_list.sortByDescending { it.name }
        productlist = product_list

        return productlist
    }
}