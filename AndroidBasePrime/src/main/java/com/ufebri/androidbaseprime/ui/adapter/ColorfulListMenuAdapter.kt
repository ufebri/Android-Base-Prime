package com.ufebri.androidbaseprime.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ufebri.androidbaseprime.databinding.ItemAdsNativeBinding
import com.ufebri.androidbaseprime.databinding.ItemMenuIconBinding
import com.ufebri.androidbaseprime.domain.model.ColorFullListMenu
import com.ufebri.androidbaseprime.ui.viewholder.vhads.AdNativeViewHolder
import com.ufebri.androidbaseprime.ui.viewholder.vhlistcolormenu.ColorFulListViewHolder
import com.ufebri.androidbaseprime.util.OnClickListener

class ColorfulListMenuAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<ColorFullListMenu, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> AdNativeViewHolder(
                ItemAdsNativeBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> ColorFulListViewHolder(
                ItemMenuIconBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            0 -> {
                val vh = holder as AdNativeViewHolder
                vh.bind(getItem(position).optionalField)
            }

            else -> {
                val itemViewHolder = holder as ColorFulListViewHolder
                itemViewHolder.bind(getItem(position), onClickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).idMenuList.contains("ads")) {
            true -> 0
            else -> 1
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ColorFullListMenu>() {
            override fun areItemsTheSame(
                oldItem: ColorFullListMenu,
                newItem: ColorFullListMenu
            ): Boolean {
                return oldItem.titleMenuList == newItem.titleMenuList
            }

            override fun areContentsTheSame(
                oldItem: ColorFullListMenu,
                newItem: ColorFullListMenu
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}