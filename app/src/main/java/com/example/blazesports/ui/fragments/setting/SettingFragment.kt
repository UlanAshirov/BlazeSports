package com.example.blazesports.ui.fragments.setting

import androidx.navigation.fragment.findNavController
import com.example.blazesports.R
import com.example.blazesports.base.BaseFragment
import com.example.blazesports.databinding.FragmentSettingBinding
import com.example.blazesports.utils.MusicManager

class SettingFragment : BaseFragment<FragmentSettingBinding>(FragmentSettingBinding::inflate) {

    override fun constructListeners() {
        binding.btnMusic.setOnClickListener {
            if (MusicManager.isMusicPlaying()) {
                MusicManager.stopMusic()
                binding.btnMusic.text = "Music:on"
            } else {
                MusicManager.startMusic(requireActivity())
                binding.btnMusic.text = "Music:off  "
            }
        }
        binding.btnPrivacy.setOnClickListener {
            findNavController().navigate(R.id.privacyFragment)
        }
        binding.btnPrev.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}