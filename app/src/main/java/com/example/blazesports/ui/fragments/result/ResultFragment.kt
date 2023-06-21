package com.example.blazesports.ui.fragments.result

import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.blazesports.R
import com.example.blazesports.base.BaseFragment
import com.example.blazesports.databinding.FragmentResultBinding

class ResultFragment : BaseFragment<FragmentResultBinding>(FragmentResultBinding::inflate) {

    override fun initialize() {
        if (arguments != null) {
            val correct = arguments?.getInt("correct")
            val wrong = arguments?.getInt("wrong")
            val score = arguments?.getInt("score")
            val time = arguments?.getString("time")

            binding.tvCountCorrectAnswers.text = correct.toString()
            binding.tvCountWrongAnswers.text = wrong.toString()
            binding.tvScore.text = score.toString()
            binding.tvTime.text = time
        }
    }

    override fun constructListeners() {
        binding.btnPlayAgain.setOnClickListener {
            findNavController().navigate(R.id.quizFragment)
        }
        binding.btnResultExit.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}