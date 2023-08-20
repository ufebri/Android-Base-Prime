package bedboy.utilitybuddy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import bedboy.utilitybuddy.databinding.ActivityMainBinding
import com.ufebri.androidbaseprime.domain.model.ColorFullListMenu
import com.ufebri.androidbaseprime.domain.model.ItemData
import com.ufebri.androidbaseprime.ui.adapter.ColorfulListMenuAdapter
import com.ufebri.androidbaseprime.util.Constant.ADS_ID_VIEWHOLDER_TYPE
import com.ufebri.androidbaseprime.util.OnClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Init adapter
        val mAdapter = ColorfulListMenuAdapter(object : OnClickListener {
            override fun onClickItem(item: ItemData) {
                Toast.makeText(this@MainActivity, item.field1s, Toast.LENGTH_LONG).show()
            }
        })

        //Show the list Menu
        binding.rvMain.adapter = mAdapter
        binding.rvMain.layoutManager =
            LinearLayoutManager(this)

        mAdapter.submitList(getListMenu())
    }

    private fun getListMenu(): List<ColorFullListMenu> {
        val cameraIntIcon = R.drawable.baseline_photo_camera_24
        val emailIntIcon = R.drawable.baseline_email_24
        val locationIntIcon = R.drawable.baseline_fmd_good_24

        return listOf(
            ColorFullListMenu(
                "1",
                "Camera",
                cameraIntIcon,
                ContextCompat.getColor(this, R.color.colorAccent)
            ),
            ColorFullListMenu(
                "2",
                "Email",
                emailIntIcon,
                ContextCompat.getColor(this, R.color.colorPrimaryDark)
            ),
            ColorFullListMenu(
                "3",
                "Location",
                locationIntIcon,
                ContextCompat.getColor(this, R.color.colorPrimary)
            ),
            ColorFullListMenu(
                ADS_ID_VIEWHOLDER_TYPE,
                "Location",
                locationIntIcon,
                ContextCompat.getColor(this, R.color.colorPrimary),
                getString(R.string.admob_native_id)
            )
        )
    }
}
