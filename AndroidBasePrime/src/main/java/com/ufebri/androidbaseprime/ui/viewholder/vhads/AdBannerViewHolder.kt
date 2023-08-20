package com.ufebri.androidbaseprime.ui.viewholder.vhads

import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdRequest
import com.ufebri.androidbaseprime.databinding.ItemAdsBannerBinding

class AdBannerViewHolder(
    private val binding: ItemAdsBannerBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind() {
        val adRequest =
            AdRequest.Builder().build()
        binding.adViewB.loadAd(adRequest)
    }
}
