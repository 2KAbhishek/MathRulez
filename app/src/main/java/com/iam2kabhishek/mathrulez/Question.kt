package com.iam2kabhishek.mathrulez

data class Question(
    val id: Int,
    val question: String,
    val options: ArrayList<String>,
    val correct: Int
)