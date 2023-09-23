package bedboy.utilitybuddy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import bedboy.utilitybuddy.DummyDataHelper.GALLERY_MENU
import bedboy.utilitybuddy.DummyDataHelper.getListMenu
import bedboy.utilitybuddy.databinding.ActivityMainBinding
import com.ufebri.androidbaseprime.domain.model.ItemData
import com.ufebri.androidbaseprime.ui.adapter.ColorfulListMenuAdapter
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
                when (item.field1s) {
                    GALLERY_MENU -> startActivity(
                        Intent(
                            this@MainActivity,
                            GalleryActivity::class.java
                        )
                    )

                    else -> Toast.makeText(this@MainActivity, item.field1s, Toast.LENGTH_LONG)
                        .show()
                }
            }
        })

        //Show the list Menu
        binding.rvMain.adapter = mAdapter
        binding.rvMain.layoutManager =
            LinearLayoutManager(this)

        mAdapter.submitList(getListMenu(this))
    }
}
