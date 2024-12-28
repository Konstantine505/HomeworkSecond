package com.example.homeworksecond.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworksecond.R
import com.example.homeworksecond.databinding.ItemViewPagerBinding
import com.example.homeworksecond.model.ProductUI

class ProductsAdapter() :
    ListAdapter<ProductUI, ProductsAdapter.ProductsViewHolder>(ProductsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ProductsViewHolder(
        ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind()
    }

    inner class ProductsViewHolder(private val binding: ItemViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: ProductUI

        fun bind() {
            model = currentList[adapterPosition]
            binding.apply {
                tvDescription.text = model.title
                tvPrice.text = model.price
                if (model.favorite) {
                    ibFavorite.setBackgroundResource(R.drawable.bg_circle_green)
                } else {
                    ibFavorite.setBackgroundResource(R.drawable.bg_circle_white)
                }
                ivProduct.setImageResource(model.imageRes)

            }
            listeners()
        }

        private fun listeners() {
            binding.root.setOnClickListener {
            }
        }
    }

    class ProductsDiffUtil : DiffUtil.ItemCallback<ProductUI>() {
        override fun areItemsTheSame(oldItem: ProductUI, newItem: ProductUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductUI, newItem: ProductUI): Boolean {
            return oldItem == newItem
        }
    }
}
