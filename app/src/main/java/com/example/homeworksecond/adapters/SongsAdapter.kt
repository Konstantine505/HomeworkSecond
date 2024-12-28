package com.example.homeworksecond.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworksecond.R
import com.example.homeworksecond.databinding.ItemRecyclerBinding
import com.example.homeworksecond.model.ProductUI
import com.example.homeworksecond.model.SongUI

class SongsAdapter() :
    ListAdapter<SongUI, SongsAdapter.SongsViewHolder>(ProductsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SongsViewHolder(
        ItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.bind()
    }

    inner class SongsViewHolder(private val binding: ItemRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: SongUI

        fun bind() {
            model = currentList[adapterPosition]
            binding.apply {
                title.text = model.name
                ivSong.setImageResource(model.cover)

            }
            listeners()
        }

        private fun listeners() {
            binding.root.setOnClickListener {
            }
        }
    }

    class ProductsDiffUtil : DiffUtil.ItemCallback<SongUI>() {
        override fun areItemsTheSame(oldItem: SongUI, newItem: SongUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SongUI, newItem: SongUI): Boolean {
            return oldItem == newItem
        }
    }
}
