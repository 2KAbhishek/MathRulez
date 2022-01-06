package com.iam2kabhishek.mathrulez

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        questionsList.add(Question(1,  "What comes after 45?", arrayListOf("44","45","46","49","50"), 3 ))
        questionsList.add(Question(2,  "What comes after 99?", arrayListOf("0","11","98","100","96"), 4 ))
        questionsList.add(Question(3,  "What is 4 + 5?", arrayListOf("45", "9", "54", "6", "11"), 2 ))
        questionsList.add(Question(4,  "What is 10 - 2?", arrayListOf("8","4", "12", "14", "6"), 1 ))
        questionsList.add(Question(5,  "What is 3 x 3?", arrayListOf("6", "3", "33", "27", "9"), 5 ))
        questionsList.add(Question(6,  "What is 10 ÷ 2?", arrayListOf("12", "20", "1", "5", "10"), 4 ))
        questionsList.add(Question(7,  "What is quarter of 12?", arrayListOf("4","3","1","2","5"), 2 ))
        questionsList.add(Question(8,  "What is half of 6?", arrayListOf("12", "2", "3", "0", "9"), 3 ))
        questionsList.add(Question(9,  "How many sides does a square have?", arrayListOf("4","8", "12", "1", "0"), 1 ))
        questionsList.add(Question(10,  "How many sides does a triangle have?", arrayListOf("5","2","7","3","9"), 4 ))
        questionsList.add(Question(11,  "Which is the heaviest?",arrayListOf("10 Pounds","2 Pounds", "1 Pound", "8 Pounds", "5 Pounds"), 1 ))
        questionsList.add(Question(12,  "Which is the shortest?", arrayListOf("3 feet", "4 feet", "2 feet", "5 feet", "6 feet"), 3 ))
        questionsList.add(Question(13,  "What is the opposite of West?", arrayListOf("Left", "Right", "South", "East", "North"), 4 ))
        questionsList.add(Question(14,  "What is the opposite of Right?", arrayListOf("Up", "Down", "South", "North", "Left"), 5 ))
        return questionsList
    }
}