package com.ufebri.androidbaseprime.ui.viewholder.vhphoto

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ufebri.androidbaseprime.R
import com.ufebri.androidbaseprime.databinding.GridViewItemBinding
import com.ufebri.androidbaseprime.domain.model.ItemData
import com.ufebri.androidbaseprime.domain.model.PhotoData
import com.ufebri.androidbaseprime.util.OnClickListener

class GridImagesViewHolder(private var binding: GridViewItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: PhotoData, onClick: OnClickListener) {

        Glide.with(binding.root)
            .load(data.imgSrc)
            .placeholder(
                ContextCompat.getDrawable(
                    binding.root.context,
                    R.drawable.loading_animation
                )
            )
            .into(binding.marsImage)

        val mData = ItemData(data.id)

        binding.root.setOnClickListener { onClick.onClickItem(mData) }
    }
}