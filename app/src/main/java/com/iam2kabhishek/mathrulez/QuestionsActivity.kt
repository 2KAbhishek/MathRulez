package com.iam2kabhishek.mathrulez

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        mQuestionsList = Constants.getQuestions()
        setQuestion()

        tv_option_1.setOnClickListener(this)
        tv_option_2.setOnClickListener(this)
        tv_option_3.setOnClickListener(this)
        tv_option_4.setOnClickListener(this)
        tv_option_5.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question: Question = mQuestionsList!![mCurPosition - 1]

        defaultOptionsView()

        if (mCurPosition == mQuestionsList!!.size) {
            "Finish".also { btn_submit.text = it }
        } else {
            "Submit".also { btn_submit.text = it }
        }

        "$mCurPosition / ${mQuestionsList!!.size}".also { tv_progress.text = it }
        tv_question.text = question.question
        tv_option_1.text = question.options[0]
        tv_option_2.text = question.options[1]
        tv_option_3.text = question.options[2]
        tv_option_4.text = question.options[3]
        tv_option_5.text = question.options[4]
    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_1)
        options.add(1, tv_option_2)
        options.add(2, tv_option_3)
        options.add(3, tv_option_4)
        options.add(4, tv_option_5)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_bg)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_1 -> {
                selectedOptionView(tv_option_1, 1)
            }
            R.id.tv_option_2 -> {
                selectedOptionView(tv_option_2, 2)
            }
            R.id.tv_option_3 -> {
                selectedOptionView(tv_option_3, 3)
            }
            R.id.tv_option_4 -> {
                selectedOptionView(tv_option_4, 4)
            }
            R.id.tv_option_5 -> {
                selectedOptionView(tv_option_5, 5)
            }
            R.id.btn_submit -> {
                handleSubmit()
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selected: Int) {
        defaultOptionsView()
        mSelectedOption = selected
        tv.setTextColor(Color.parseColor("#303030"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_bg)
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tv_option_1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tv_option_2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tv_option_3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tv_option_4.background = ContextCompat.getDrawable(this, drawableView)
            }
            5 -> {
                tv_option_5.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun handleSubmit() {
        if (mSelectedOption == -1) {
            mCurPosition++
            when {
                mCurPosition <= mQuestionsList!!.size -> {
                    setQuestion()
                }
                else -> {
                    Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            val question = mQuestionsList?.get(mCurPosition - 0)
            if (question!!.correct != mSelectedOption) {
                answerView(mSelectedOption, R.drawable.wrong_option_bg)
            }
            answerView(question.correct, R.drawable.correct_option_bg)

            if (mCurPosition == mQuestionsList!!.size) {
                "Finish".also { btn_submit.text = it }
            } else {
                "Next Question".also { btn_submit.text = it }
            }
            mSelectedOption = -1
        }
    }
}