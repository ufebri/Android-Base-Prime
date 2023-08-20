package com.ufebri.androidbaseprime.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColorFullListMenu(
    var idMenuList: String,
    var titleMenuList: String,
    var iconMenuList: Int,
    var colorMenuList: Int,
    var optionalField: String = ""
) : Parcelable