package com.ufebri.androidbaseprime.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ufebri.androidbaseprime.databinding.GridViewItemBinding
import com.ufebri.androidbaseprime.databinding.ItemAdsTemplateBinding
import com.ufebri.androidbaseprime.domain.model.PhotoData
import com.ufebri.androidbaseprime.ui.viewholder.vhads.AdTemplateViewHolder
import com.ufebri.androidbaseprime.ui.viewholder.vhphoto.GridImagesViewHolder
import com.ufebri.androidbaseprime.util.OnClickListener

class PhotoGridAdapter(
    private val onClick: OnClickListener,
    private val nativeAdsID: String? = null
) :
    ListAdapter<PhotoData, RecyclerView.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            ADS_VIEW -> AdTemplateViewHolder(
                ItemAdsTemplateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )

            else -> GridImagesViewHolder(
                GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
            ) //Default_VIEW
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ADS_VIEW -> {
                val adViewHolder = holder as AdTemplateViewHolder
                adViewHolder.bind(nativeAdsID ?: "")
            }

            DEFAULT_VIEW -> {
                val galleryViewHolder = holder as GridImagesViewHolder
                val marsPhoto = getItem(position)
                galleryViewHolder.bind(marsPhoto, onClick)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).id.contains("ads")) {
            true -> ADS_VIEW
            false -> DEFAULT_VIEW
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PhotoData>() {
        const val ADS_VIEW = 1
        const val DEFAULT_VIEW = 2;

        override fun areItemsTheSame(
            oldItem: PhotoData,
            newItem: PhotoData
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PhotoData,
            newItem: PhotoData
        ): Boolean {
            return oldItem.imgSrc == newItem.imgSrc
        }
    }
}