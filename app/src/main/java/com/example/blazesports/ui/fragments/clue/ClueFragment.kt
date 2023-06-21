package com.example.blazesports.ui.fragments.clue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.blazesports.R
import com.example.blazesports.databinding.FragmentClueBinding
import com.example.blazesports.model.QuizModel

class ClueFragment : DialogFragment() {
    private lateinit var binding: FragmentClueBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setBackgroundDrawableResource(R.drawable.clue_bg)
        binding = FragmentClueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            val model = arguments?.getSerializable("clue") as QuizModel
            binding.imgClue.setImageResource(model.clueImage)
            binding.tvClue.text = model.clue
        }

        binding.btnClueBack.setOnClickListener {
            dismiss()
        }
    }
}