[![](https://jitpack.io/v/ufebri/Android-Base-Prime.svg)](https://jitpack.io/#ufebri/Android-Base-Prime)

# Android Base Prime
The library for all you need for Helper, Extension and CustomView for your next Android Project.

## How to Install

    implementation 'com.github.ufebri:Android-Base-Prime:@latest_version'

## How to use
Theres many function you can try, lets choose one.

### ColorfulListMenuRecyclerView
<img src="asset/ColorfulListMenuRecyclerView.gif" height="400" alt="ColorfulListMenuRecyclerView v1.0"/>

Put this code on your Activity/Fragment.

    //Init adapter  
    val mAdapter = ColorfulListMenuAdapter(object : OnClickListener {  
        override fun onClickItem(item: ItemData) {  
        //Handle On Your Click
            Toast.makeText(this@MainActivity, item.field1s, Toast.LENGTH_LONG).show()  
        }  
    })  
      
    //Show the list Menu  
    binding.rvMain.apply {  
      adapter = mAdapter  
      layoutManager = LinearLayoutManager(this@MainActivity)  
    }  
      
    mAdapter.submitList(getListMenu())

Lets say your list menu is like this

    private fun getListMenu(): List<ColorFullListMenu> {  
      val cameraIntIcon = R.drawable.baseline_photo_camera_24  
      val emailIntIcon = R.drawable.baseline_email_24  
      val locationIntIcon = R.drawable.baseline_fmd_good_24  
      
      return listOf(  
            ColorFullListMenu("1","Camera", cameraIntIcon,ContextCompat.getColor(this, R.color.colorAccent)),
            ColorFullListMenu("2","Email",emailIntIcon, ContextCompat.getColor(this, R.color.colorPrimaryDark)),
            ColorFullListMenu("3","Location",locationIntIcon,ContextCompat.getColor(this, R.color.colorPrimary))
            }
