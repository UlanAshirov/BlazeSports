package com.example.blazesports.model

data class QuizModel(
    val id: Int,
    val image: Int,
    val question: String,
    val correctAnswer: String,
    val clue: String,
    val clueImage: Int,
    val options: List<String>
) : java.io.Serializable
