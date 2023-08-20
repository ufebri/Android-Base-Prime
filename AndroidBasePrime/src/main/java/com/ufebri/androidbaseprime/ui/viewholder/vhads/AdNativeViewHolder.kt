package com.ufebri.androidbaseprime.ui.viewholder.vhads

import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.ufebri.androidbaseprime.databinding.ItemAdsNativeBinding


/**
 * Created by Uray Febri on 30/03/2022.
 */
class AdNativeViewHolder(
    private val binding: ItemAdsNativeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(nativeIDAds: String) {
        val context = binding.root.context

        val adLoader = AdLoader.Builder(context, nativeIDAds)
            .forNativeAd { nativeAd ->
                binding.tvTitleAds.text = nativeAd.headline
                binding.tvMsgAds.text = nativeAd.body
                binding.ivAds.setImageDrawable(nativeAd.images[0].drawable)
                binding.btnCat.text = nativeAd.callToAction
            }
            .withNativeAdOptions(NativeAdOptions.Builder().build())
            .build()

        val adRequest = AdRequest.Builder().build()
        adLoader.loadAd(adRequest)
    }
}