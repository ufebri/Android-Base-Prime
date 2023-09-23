package bedboy.utilitybuddy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import bedboy.utilitybuddy.DummyDataHelper.getListImage
import bedboy.utilitybuddy.databinding.ActivityGalleryBinding
import com.ufebri.androidbaseprime.domain.model.ItemData
import com.ufebri.androidbaseprime.ui.adapter.PhotoGridAdapter
import com.ufebri.androidbaseprime.util.OnClickListener
import com.ufebri.androidbaseprime.util.RemappingDataWithAds.remappingGalleryList

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //init adapter
        val mAdapter = PhotoGridAdapter(object : OnClickListener {
            override fun onClickItem(item: ItemData) {
                Toast.makeText(this@GalleryActivity, "Clicked ${item.field1s}", Toast.LENGTH_LONG)
                    .show()
            }
        }, getString(R.string.admob_native_id))

        //show the images
        binding.apply {
            photosGrid.adapter = mAdapter
            photosGrid.layoutManager =
                GridLayoutManager(this@GalleryActivity, 2, GridLayoutManager.VERTICAL, false)
        }

        mAdapter.submitList(remappingGalleryList(getListImage()))
    }
}