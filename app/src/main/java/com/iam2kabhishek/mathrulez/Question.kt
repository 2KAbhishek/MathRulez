package com.iam2kabhishek.mathrulez

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correct: Int
)