package com.ufebri.androidbaseprime.util

import com.ufebri.androidbaseprime.domain.model.PhotoData

object RemappingDataWithAds {

    fun remappingGalleryList(mDataList: List<PhotoData>): List<PhotoData> {
        val dataList = mutableListOf<PhotoData>()

        for (index in mDataList.indices) {
            dataList.add(mDataList[index])

            if (index != 0 && index % ConstantConfig.COUNT_ADS_VIEW == 0) {
                dataList.add(setDataAdsPhoto())
            }
        }

        return dataList
    }

    private fun setDataAdsPhoto(): PhotoData {
        val index: IntRange = 1..99
        return PhotoData(
            id = "$index-ads"
        )
    }
}