package com.example.blazesports.ui.fragments.quiz

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import androidx.navigation.fragment.findNavController
import com.example.blazesports.R
import com.example.blazesports.base.BaseFragment
import com.example.blazesports.databinding.FragmentQuizBinding
import com.example.blazesports.model.QuizModel
import kotlin.random.Random

class QuizFragment : BaseFragment<FragmentQuizBinding>(FragmentQuizBinding::inflate) {

    private lateinit var countDownTimer: CountDownTimer
    private val totalTimeInMillis: Long = 60000
    private val intervalInMillis: Long = 1000
    private val listQuestions = mutableListOf<QuizModel>()
    private var score = 0
    private var correctAnswer = 0
    private var wrongAnswer = 0
    override fun initialize() {
        listQuestions.add(
            QuizModel(
                1,
                R.drawable.img1,
                "Сколько голов забил Роналду за всю свою карьеру?",
                "837",
                "Лучший бомбардир в истории футбола в официальных матчах: 837 гола Лучший бомбардир в истории сборных: 122 гола Рекордсмен по числу матчей за сборную: 198. Лучший бомбардир в истории чемпионатов Европы: 14 голов",
                R.drawable.img_2,
                listOf(
                    "423",
                    "837",
                    "234",
                    "864"
                )
            )
        )
        listQuestions.add(
            QuizModel(
                2, R.drawable.img,
                "Сколько золотых мячей у Месси?",
                "7",
                "Лучший бомбардир в истории чемпионата Испании, «Барселоны» и сборной Аргентины. Семикратный обладатель «Золотого мяча», шестикратный — «Золотой бутсы».",
                R.drawable.img_3,
                listOf(
                    "5",
                    "6",
                    "9",
                    "7"
                )
            )
        )
        listQuestions.add(
            QuizModel(
                3,
                R.drawable.img_1,
                "Самый быстрый футболист в мире?",
                "Килиан Мбаппе",
                "Согласно исследованию Marca, из всех представителей игровых видов спорта ближе всех к Болту в этом виртуальном забеге подобрался бы нападающий «Пари Сен-Жермен» (ПСЖ) и сборной Франции Килиан Мбаппе. Он преодолел бы стометровку за 11 секунд (максимальная скорость — 38,01 км/ч)",
                R.drawable.img_4,
                listOf(
                    "Гарет Бэйл",
                    "Криштиану Роналду",
                    "Килиан Мбаппе",
                    "Пьер-Эмерик Обамеянг"
                )
            )
        )

        countDownTimer = object : CountDownTimer(totalTimeInMillis, intervalInMillis) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = millisUntilFinished / 1000 % 60
                binding.tvTimer.text = String.format("%02d:%02d", minutes, seconds)
            }

            override fun onFinish() {
                binding.tvTimer.text = "00:00"
            }
        }
        countDownTimer.start()
    }

    override fun constructListeners() {
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        randomQuiz()
    }


    private fun randomQuiz() {
        var optionsText = ""
        var random = Random.nextInt(0, listQuestions.size)
        if (listQuestions.size == 1 || random == 0) {
            random = 0
        } else {
            random--
        }
        binding.imgQuiz.setImageResource(listQuestions[random].image)
        binding.tvQuizQuestion.text = listQuestions[random].question
        binding.btnOptions2.text = listQuestions[random].options[0]
        binding.btnOptions1.text = listQuestions[random].options[1]
        binding.btnOptions3.text = listQuestions[random].options[2]
        binding.btnOptions4.text = listQuestions[random].options[3]
        binding.btnOptions1.setBackgroundColor(Color.parseColor("#e9153a"))
        binding.btnOptions2.setBackgroundColor(Color.parseColor("#e9153a"))
        binding.btnOptions3.setBackgroundColor(Color.parseColor("#e9153a"))
        binding.btnOptions4.setBackgroundColor(Color.parseColor("#e9153a"))

        binding.btnClue.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("clue" ,listQuestions[random])
            findNavController().navigate(R.id.clueFragment, bundle)
        }
        binding.btnCheck.setOnClickListener {
            score++
            if (optionsText == listQuestions[random].correctAnswer) {
                correctAnswer++
            } else {
                wrongAnswer++
            }
            listQuestions.removeAt(random)

            if (listQuestions.isEmpty()) {
                countDownTimer.cancel()
                val bundle = Bundle()
                bundle.putInt("correct", correctAnswer)
                bundle.putInt("wrong", wrongAnswer)
                bundle.putInt("score", score)
                bundle.putString("time", binding.tvTimer.text.toString())
                findNavController().navigateUp()
                findNavController().navigate(R.id.resultFragment, bundle)
            } else {
                randomQuiz()
            }
        }
        binding.btnOptions1.setOnClickListener {
            optionsText = binding.btnOptions1.text.toString()
            binding.btnOptions1.setBackgroundColor(Color.parseColor("#36CC3C"))
        }
        binding.btnOptions2.setOnClickListener {
            optionsText = binding.btnOptions2.text.toString()
            binding.btnOptions2.setBackgroundColor(Color.parseColor("#36CC3C"))
        }
        binding.btnOptions3.setOnClickListener {
            optionsText = binding.btnOptions3.text.toString()
            binding.btnOptions3.setBackgroundColor(Color.parseColor("#36CC3C"))
        }
        binding.btnOptions4.setOnClickListener {
            optionsText = binding.btnOptions4.text.toString()
            binding.btnOptions4.setBackgroundColor(Color.parseColor("#36CC3C"))
        }
    }
}