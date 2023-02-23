package com.assignment.victoriassecret.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.assignment.victoriassecret.R
import com.assignment.victoriassecret.databinding.FragmentHomeBinding
import com.assignment.victoriassecret.view.adapter.ViewPagerAdapter
import com.assignment.victoriassecret.viewModel.HomeFragmentViewModel
import com.assignment.victoriassecret.viewModel.ProductDetailViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {
    private var indicatorWidth = 0
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeFragmentViewModel by viewModels()
    var tabnames: ArrayList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
        setupTabLayout()
        Log.e("TAG", "itemClick:oncreat "+findNavController().currentDestination )

    }

    private fun setupTabLayout() {
        tabnames.add(0, "ProductList")
        tabnames.add(1, "Profile")
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabnames[position]
        }.attach()
        val adapter = ViewPagerAdapter(requireActivity(), 2)
        binding.viewPager.adapter = adapter
        binding.tabLayout.post(Runnable {
            indicatorWidth = binding.tabLayout.width / binding.tabLayout.tabCount

            //Assign new width
            val indicatorParams =
                binding.indicator.layoutParams as FrameLayout.LayoutParams
            indicatorParams.width = indicatorWidth
            binding.indicator.layoutParams = indicatorParams
        })


        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)


                val params = binding.indicator.layoutParams as FrameLayout.LayoutParams
                //Multiply positionOffset with indicatorWidth to get translation
                val translationOffset: Float = (positionOffset + position) * indicatorWidth
                params.leftMargin = translationOffset.toInt()
                binding.indicator.layoutParams = params
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.currentNavController =position

            }

        })


    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(requireActivity(), 2)
        binding.viewPager.adapter = adapter


    }


    /*override fun onBackPressed() {
        val viewPager = binding.viewPager
        if (viewPager.currentItem == 0) {
         super.onBackPressed()
        } else {
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }*/
    override fun onDestroyView() {

        val viewPager2 = binding?.viewPager

        /*
            Without setting ViewPager2 Adapter it causes memory leak
            https://stackoverflow.com/questions/62851425/viewpager2-inside-a-fragment-leaks-after-replacing-the-fragment-its-in-by-navig
         */
        viewPager2?.let {
            it.adapter = null
        }

        super.onDestroyView()
    }

}