package com.ufebri.androidbaseprime.ui.viewholder.vhlistcolormenu

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ufebri.androidbaseprime.databinding.ItemMenuIconBinding
import com.ufebri.androidbaseprime.domain.model.ColorFullListMenu
import com.ufebri.androidbaseprime.domain.model.ItemData
import com.ufebri.androidbaseprime.util.OnClickListener

class ColorFulListViewHolder(private val binding: ItemMenuIconBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ColorFullListMenu, onClickListener: OnClickListener) {
        binding.apply {
            tvMenuIc.text = item.titleMenuList
            ivMenuIc.setImageDrawable(
                ContextCompat.getDrawable(
                    binding.root.context,
                    item.iconMenuList
                )
            )
            cvCardMenu.setCardBackgroundColor(item.colorMenuList)
        }

        //Handle OnClick
        binding.root.setOnClickListener { onClickListener.onClickItem(ItemData(item.idMenuList)) }
    }
}