package com.iam2kabhishek.mathrulez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionsList = Constants.getQuestions()

        val curPosition = 1
        val question: Question? = questionsList[curPosition - 1]

        tv_progress.text = "${curPosition} / ${questionsList.size}"
        tv_question.text = question!!.question
        tv_option_1.text = question.options[0]
        tv_option_2.text = question.options[1]
        tv_option_3.text = question.options[2]
        tv_option_4.text = question.options[3]
        tv_option_5.text = question.options[4]


    }
}