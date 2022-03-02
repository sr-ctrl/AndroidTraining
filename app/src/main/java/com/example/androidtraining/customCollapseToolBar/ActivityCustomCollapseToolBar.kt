package com.example.androidtraining.customCollapseToolBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.collapseToolBar.ContactFragment
import com.example.androidtraining.collapseToolBar.GroupFragment
import com.example.androidtraining.collapseToolBar.LocationFragment
import com.example.androidtraining.databinding.ActivityCollapsibleToolbarBinding
import com.example.androidtraining.databinding.ActivityCustomCollpaseToolbarBinding
import com.example.androidtraining.fragment.FragmentA
import com.example.androidtraining.fragment.FragmentB
import com.example.androidtraining.fragment.FragmentC
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs

class ActivityCustomCollapseToolBar:BaseActivity() {

    lateinit var binding: ActivityCustomCollpaseToolbarBinding
    private val tabCustomViewPager by lazy { CustomTabLayout(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_collpase_toolbar)
        onCreatedViewDone()
    }

    override fun init() {

    }

    override fun observe() {

    }

    override fun setListener() {
        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            if (abs(verticalOffset) >= binding.appBarLayout.totalScrollRange) {
//
//                val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
//                binding.tvSubHeading.startAnimation(animationFadeIn)
//                binding.tvSubTitleHeading.startAnimation(animationFadeIn)
////                binding.MainHeading.startAnimation(animationFadeIn)
                binding.searchEtx.visibility = View.GONE

            } else {

//                binding.toolbar.visibility = View.GONE
                binding.toolbar.title = "Dummy Text"
//                val animationText = AnimationUtils.loadAnimation(this,R.anim.slide_up)
//                binding.collapsingToolbar.startAnimation(animationText)
                val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
                binding.tvSubHeading.startAnimation(animationFadeIn)
                binding.tvSubTitleHeading.startAnimation(animationFadeIn)
                binding.MainHeading.startAnimation(animationFadeIn)
                binding.searchEtx.visibility = View.VISIBLE
            }
        })

    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//        inflater.inflate(R.menu.main, menu)
//        // return true so that the menu pop up is opened
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    override fun load() {
        //to enable back btn
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        //ViewPager2
        binding.viewPager.adapter = tabCustomViewPager
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.offscreenPageLimit = 3
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager, false, false
        ) { tab, position ->
            val tabView =
                LayoutInflater.from(this@ActivityCustomCollapseToolBar)
                    .inflate(R.layout.custom_tab_item, null) as View
            (tabView.findViewById(R.id.textView) as TextView).text = getTitleNResId(position)[0]!!
            tab.customView = tabView
        }.attach()
    }

    private fun getTitleNResId(position: Int): Array<String?> {
        return when (position){
            0 -> {
                arrayOf(TabName.TabCamera.tabName, null)
            }
            1 -> {
                arrayOf(TabName.TabContact.tabName, null)
            }

            else -> {
                arrayOf(TabName.TabData.tabName, null)
            }
        }
    }

    inner class CustomTabLayout(manager: AppCompatActivity) : FragmentStateAdapter(manager){
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            return when (position){
                0-> {
                    TabFragmentCamera.newInstance()
                }
                1-> {
                    TabFragmentContact.newInstance()
                }
                else -> TabFragmentData.newInstance()
            }
        }

    }
}

enum class TabName(val tabName:String){
    TabCamera("Camera"),
    TabContact("Contact"),
    TabData("Data")
}


