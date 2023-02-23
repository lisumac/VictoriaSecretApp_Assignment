package com.assignment.victoriassecret.view.fragments

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.assignment.victoriassecret.R
import com.assignment.victoriassecret.databinding.FragmentProductsLayoutBinding
import com.assignment.victoriassecret.databinding.FragmentUserProfileLayoutBinding
import com.assignment.victoriassecret.viewModel.ProductListViewModel
import com.assignment.victoriassecret.viewModel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    lateinit var _binding: FragmentUserProfileLayoutBinding
    private val binding get() = _binding!!
    private val viewModels: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserProfileLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupData()

    }

    @SuppressLint("SetTextI18n")
    private fun setupData() {
        binding.progressBar.visibility = View.GONE
        viewModels.userDetails.observe(requireActivity()) { result ->
            binding.tvUserAddressValue.text = result.address
            val fName = StringBuilder(result.firstname)
            val lName = StringBuilder(result.lastName)
            val full_name = fName.append(lName)
            binding.tvUserFlnameValue.text = full_name
            binding.tvPointEarnedValue.text = result.pointsEarned
            binding.tvWalletBalanceValue.text = result.walletBalance

        }
    }
}