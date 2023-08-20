package com.ufebri.androidbaseprime.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment

fun Fragment.startActivity(className: String, extras: Bundle? = null) {
    val intent = Intent().apply {
        setClassName(requireContext(), className)
        extras?.let { putExtras(it) }
    }
    startActivity(intent)
}

fun Activity.startActivity(className: String, extras: Bundle? = null) {
    val intent = Intent().apply {
        setClassName(this@startActivity, className)
        extras?.let { putExtras(it) }
    }
    startActivity(intent)
}