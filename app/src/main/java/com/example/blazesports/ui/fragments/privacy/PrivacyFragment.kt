package com.example.blazesports.ui.fragments.privacy

import androidx.navigation.fragment.findNavController
import com.example.blazesports.base.BaseFragment
import com.example.blazesports.databinding.FragmentPrivacyBinding

class PrivacyFragment : BaseFragment<FragmentPrivacyBinding>(FragmentPrivacyBinding::inflate) {

    override fun constructListeners() {
        binding.btnPrivacyBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}