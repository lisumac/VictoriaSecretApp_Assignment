package com.assignment.victoriassecret.view.activity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.assignment.victoriassecret.R
import com.assignment.victoriassecret.databinding.ActivityDashBoardBinding
import com.assignment.victoriassecret.view.adapter.ViewPagerAdapter
import com.assignment.victoriassecret.viewModel.DashBoardViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashBoardActivity : AppCompatActivity() {
    lateinit var dashboardBinding: ActivityDashBoardBinding
    var tabnames: ArrayList<String> = ArrayList()
    private var indicatorWidth = 0
    private val dashBoardViewModel: DashBoardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBindingAndViewModel()
        setupViewPager()
        setupTabLayout()


    }

    private fun initDataBindingAndViewModel() {
        dashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)

        dashboardBinding.dashboardVm = dashBoardViewModel
        //dashboardBinding.handlr = this
        dashboardBinding.lifecycleOwner = this;

    }

    private fun setupTabLayout() {
        // tabnames.add(0,"TabName")
        tabnames.add(0, "ProductList")
        tabnames.add(1, "Profile")
        TabLayoutMediator(dashboardBinding.tabLayout, dashboardBinding.viewPager) { tab, position ->
            tab.text = tabnames[position]
        }.attach()
        val adapter = ViewPagerAdapter(this, 2)
        dashboardBinding.viewPager.adapter = adapter
        dashboardBinding.tabLayout.post(Runnable {
            indicatorWidth = dashboardBinding.tabLayout.width / dashboardBinding.tabLayout.tabCount

            //Assign new width
            val indicatorParams =
                dashboardBinding.indicator.layoutParams as FrameLayout.LayoutParams
            indicatorParams.width = indicatorWidth
            dashboardBinding.indicator.layoutParams = indicatorParams
        })


        dashboardBinding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)


                val params = dashboardBinding.indicator.layoutParams as FrameLayout.LayoutParams
                //Multiply positionOffset with indicatorWidth to get translation
                val translationOffset: Float = (positionOffset + position) * indicatorWidth
                params.leftMargin = translationOffset.toInt()
                dashboardBinding.indicator.layoutParams = params
            }

        })


    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this, 2)
        dashboardBinding.viewPager.adapter = adapter


    }

    override fun onBackPressed() {
        val viewPager = dashboardBinding.viewPager
        if (viewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }
}