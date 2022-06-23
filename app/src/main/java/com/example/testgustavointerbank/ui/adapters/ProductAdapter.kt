package com.example.testgustavointerbank.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.Entity.ProductEntity
import com.example.testgustavointerbank.databinding.ItemProductLayoutBinding
import com.example.testgustavointerbank.models.ProductModel

class ProductAdapter(
    private var onItemClicked: ((product: ProductModel) -> Unit)
) : RecyclerView.Adapter<ProductAdapter.CarViewHolder>() {

    private var listProducts : List<ProductModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemCarLayoutBinding = ItemProductLayoutBinding.inflate(inflater, parent,false)
        return CarViewHolder(itemCarLayoutBinding)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        holder.bind(listProducts[position])
    }

    override fun getItemCount(): Int {
        return listProducts.size
    }

    inner class CarViewHolder(val binding : ItemProductLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product : ProductModel){
            binding.apply {
                cuentaType.text = product.typeAccount
                cuentaMount.text = product.mountAccount
                root.setOnClickListener{
                    onItemClicked(product)
                }
            }
        }
    }

    fun setData(newListProducts : List<ProductModel>){
        listProducts = newListProducts
        notifyDataSetChanged()
    }
}