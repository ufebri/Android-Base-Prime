package com.ufebri.androidbaseprime.util

import android.content.Context
import android.content.Intent

fun Context.shareData(
    title: String,
    urlApps: String,
    appName: String
) {
    val text = "Check this recipe: $title just on $urlApps"

    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, appName)
        putExtra(Intent.EXTRA_TEXT, text)

    }

    startActivity(Intent.createChooser(shareIntent, "Share via"))
}
