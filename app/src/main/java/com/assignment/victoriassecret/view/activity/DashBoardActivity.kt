package com.assignment.victoriassecret.view.activity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
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
    lateinit var navController: NavController
    private val dashBoardViewModel: DashBoardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBindingAndViewModel()



    }

    private fun initDataBindingAndViewModel() {
        dashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)

        dashboardBinding.dashboardVm = dashBoardViewModel
        dashboardBinding.lifecycleOwner = this;

    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}