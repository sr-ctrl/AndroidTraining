package com.example.androidtraining.collapseToolBar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidtraining.R
import com.example.androidtraining.base.BaseActivity
import com.example.androidtraining.databinding.ActivityCollapsibleToolbarBinding
import com.example.androidtraining.mvvmRetrofit.FragmentPost
import com.example.androidtraining.mvvmShopping.ShoppingFragment
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayoutMediator

class ActivityCollapseToolBar:BaseActivity() {

    lateinit var binding: ActivityCollapsibleToolbarBinding
    private val customViewPager by lazy { CustomViewPagerAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_collapsible_toolbar)
        onCreatedViewDone()
    }
    override fun init() {

    }

    override fun observe() {
    }

    override fun setListener() {
//        binding.appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
//            if (abs(verticalOffset) >= binding.appbar.totalScrollRange) {
//                binding.collapsingToolbar.title = "sample Text"
//            } else {
//
//                binding.collapsingToolbar.title = "Sample Title"
//            }
//        })

    }

    override fun load() {
        binding.appbar.addOnOffsetChangedListener(object :
            AppBarLayout.OnOffsetChangedListener {
            var isHidden = false
            var scrollPosition = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollPosition == -1) {
                    scrollPosition = appBarLayout.totalScrollRange
                }
                if (scrollPosition + verticalOffset == 0) {
                    isHidden = true
                    binding.titleHeading.visibility = View.VISIBLE
                    val animationFadeIn = AnimationUtils.loadAnimation(this@ActivityCollapseToolBar, R.anim.fade_in)
                    binding.titleHeading.startAnimation(animationFadeIn)
                } else if (isHidden) {
                    isHidden = false
//                    binding.txtYearMakeModel.visibility = View.VISIBLE
                    val animationFadeIn = AnimationUtils.loadAnimation(this@ActivityCollapseToolBar, R.anim.fade_in)
                    binding.titleHeading.visibility = View.GONE
                }
//
            }
        })
        //enable back btn
//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        //ViewPager2
        binding.viewPager.adapter = customViewPager
        binding.viewPager.offscreenPageLimit = 4
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager, false, false
        ) { tab, position ->
            val tabView =
                LayoutInflater.from(this@ActivityCollapseToolBar)
                    .inflate(R.layout.custom_tab_item, null) as View
            (tabView.findViewById(R.id.textView) as TextView).text = getNameTab(position)[0]!!
            tab.customView = tabView
        }.attach()
    }

    private fun getNameTab(position: Int): Array<String?> {
        return when (position){
            0 -> {
                arrayOf(TabNames.TabContact.tabName, null)
            }
            1 -> {
                arrayOf(TabNames.TabShopping.tabName, null)
            }
            2 -> arrayOf(TabNames.TabPost.tabName, null)

            else -> {
                arrayOf(TabNames.TabLocation.tabName, null)
            }
        }
    }

    inner class CustomViewPagerAdapter(manager: AppCompatActivity) : FragmentStateAdapter(manager){
        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            return when (position){
                0-> {
                    ContactFragment.newInstance()
                }
                1-> {
                    ShoppingFragment.newInstance()
                }
                2 -> {
                    FragmentPost.newInstance()
                }
                else -> LocationFragment.newInstance()
            }
        }

    }
}


enum class TabNames(val tabName: String) {
    TabContact("Contact"), TabShopping("Shopping"), TabLocation("Location"),TabPost("Post")
}