package com.example.blazesports.ui.fragments.menu

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.blazesports.R
import com.example.blazesports.base.BaseFragment
import com.example.blazesports.databinding.FragmentMenuBinding

class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    override fun constructListeners() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)
        }
        binding.btnSetting.setOnClickListener {
            findNavController().navigate(R.id.settingFragment)
        }
        binding.btnExit.setOnClickListener {
            requireActivity().finish()
        }
    }
}