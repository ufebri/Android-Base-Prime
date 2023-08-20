package com.ufebri.androidbaseprime.ui.viewholder.vhads

import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.ufebri.androidbaseprime.databinding.ItemAdsTemplateBinding


/**
 * Created by Uray Febri on 30/03/2022.
 */
class AdTemplateViewHolder(
    private val binding: ItemAdsTemplateBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(nativeIDAdmob: String) {
        val context = binding.root.context

        val adLoader = AdLoader.Builder(context, nativeIDAdmob)
            .forNativeAd { nativeAd ->
                binding.adNative.setNativeAd(nativeAd)
            }
            .build()

        val adRequest = AdRequest.Builder().build()
        adLoader.loadAd(adRequest)
    }
}