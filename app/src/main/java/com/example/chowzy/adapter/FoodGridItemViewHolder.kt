package com.example.chowzy.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.chowzy.base.ViewHolderBinder
import com.example.chowzy.data.model.Menu
import com.example.chowzy.databinding.ItemMenuGridBinding
import com.example.chowzy.presentation.home.adapter.OnItemClickedListener
import com.example.chowzy.utils.toRupiahFormat

class FoodGridItemViewHolder(
    private val binding: ItemMenuGridBinding,
    private val listener: OnItemClickedListener<Menu>
) : RecyclerView.ViewHolder(binding.root),
    ViewHolderBinder<Menu> {
    override fun bind(item: Menu) {
        item.let {
            binding.ivFoodImage.load(it.imgUrl) {
                crossfade(true)
            }
            binding.tvFoodName.text = it.name
            binding.tvFoodPrice.text = it.price.toRupiahFormat()

            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}