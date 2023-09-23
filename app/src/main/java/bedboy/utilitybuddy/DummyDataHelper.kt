package bedboy.utilitybuddy

import android.content.Context
import androidx.core.content.ContextCompat
import com.ufebri.androidbaseprime.domain.model.ColorFullListMenu
import com.ufebri.androidbaseprime.domain.model.PhotoData

object DummyDataHelper {

    const val GALLERY_MENU = "1"


    fun getListMenu(context: Context): List<ColorFullListMenu> {
        val galleryIntIcon = R.drawable.baseline_photo_library_24
        val emailIntIcon = R.drawable.baseline_email_24
        val locationIntIcon = R.drawable.baseline_fmd_good_24

        return listOf(
            ColorFullListMenu(
                GALLERY_MENU,
                "Gallery",
                galleryIntIcon,
                ContextCompat.getColor(context, R.color.colorAccent)
            ),
            ColorFullListMenu(
                "2",
                "Email",
                emailIntIcon,
                ContextCompat.getColor(context, R.color.colorPrimaryDark)
            ),
            ColorFullListMenu(
                "3",
                "Location",
                locationIntIcon,
                ContextCompat.getColor(context, R.color.colorPrimary)
            ),
//            ColorFullListMenu(
//                ADS_ID_VIEWHOLDER_TYPE,
//                "Location",
//                locationIntIcon,
//                ContextCompat.getColor(this, R.color.colorPrimary),
//                getString(R.string.admob_native_id)
//            )
        )
    }

    fun getListImage(): List<PhotoData> {
        return listOf(
            PhotoData("1", "https://i.waifu.pics/-BiHx-0.gif"),
            PhotoData("2", "https://i.waifu.pics/c2LToYU.gif"),
            PhotoData("3", "https://i.waifu.pics/Oci~KID.gif"),
            PhotoData("4", "https://i.waifu.pics/2qqO27z.gif"),
            PhotoData("5", "https://i.waifu.pics/2qqO27z.gif"),
            PhotoData("6", "https://i.waifu.pics/7hfyVIh.gif"),
            PhotoData("7", "https://i.waifu.pics/45MUw69.gif"),
            PhotoData("8", "https://i.waifu.pics/OSFgl1_.gif"),
            PhotoData("9", "https://i.waifu.pics/uWReKnM.gif"),
            PhotoData("10", "https://i.waifu.pics/fWfQO0f.gif"),
            PhotoData("11", "https://i.waifu.pics/Fj1a1_r.gif"),
            PhotoData("1", "https://i.waifu.pics/-BiHx-0.gif"),
            PhotoData("2", "https://i.waifu.pics/c2LToYU.gif"),
            PhotoData("3", "https://i.waifu.pics/Oci~KID.gif"),
            PhotoData("4", "https://i.waifu.pics/2qqO27z.gif"),
            PhotoData("5", "https://i.waifu.pics/2qqO27z.gif"),
            PhotoData("6", "https://i.waifu.pics/7hfyVIh.gif"),
            PhotoData("7", "https://i.waifu.pics/45MUw69.gif"),
            PhotoData("8", "https://i.waifu.pics/OSFgl1_.gif"),
            PhotoData("9", "https://i.waifu.pics/uWReKnM.gif"),
            PhotoData("10", "https://i.waifu.pics/fWfQO0f.gif"),
            PhotoData("11", "https://i.waifu.pics/Fj1a1_r.gif")
        )
    }
}