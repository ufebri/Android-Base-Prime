package com.ufebri.androidbaseprime.util

import androidx.core.text.HtmlCompat

/**
 * Created by Uray Febri on 07/01/2022.
 */
object GeneralHelper {

    /**
     * [getBulletList] return order list string
     */
    fun getBulletList(items: List<String>): String {
        val SPACE = " "
        val BULLET_SYMBOL = "&#8226"
        val EOL = System.getProperty("line.separator")
        val listBuilder = StringBuilder()

        val filteredList = items.filter { it.isNotBlank() && it != "null null" }.toList()

        if (items.isNotEmpty() && !items.equals("")) {
            for (item in filteredList) {
                val formattedItem = HtmlCompat.fromHtml(
                    BULLET_SYMBOL + SPACE + item,
                    HtmlCompat.FROM_HTML_MODE_COMPACT
                )
                listBuilder.append(formattedItem.toString() + EOL)
            }
        }
        return listBuilder.toString()
    }

}