package com.bignerdranch.android.geoquiz_second

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var backButton: ImageButton

    private lateinit var questionTextView:
            TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    private var currentScore = 0.0
    private var lockedQuestions = mutableListOf<Int>()
    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton =
            findViewById(R.id.true_button)
        falseButton =
            findViewById(R.id.false_button)
        nextButton =
            findViewById(R.id.next_button)
        backButton =
            findViewById(R.id.back_button)
        questionTextView =
            findViewById(R.id.question_text_view)

        trueButton.setOnClickListener {
            lockedQuestions.add(currentIndex)
            checkAnswer(true)

        }
        falseButton.setOnClickListener {
            lockedQuestions.add(currentIndex)
            checkAnswer(false)

        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) %
                    questionBank.size
            isAnswered(currentIndex)
            updateQuestion()

        }
        backButton.setOnClickListener {
            currentIndex = if (currentIndex != 0) {
                (currentIndex - 1) %
                        questionBank.size

            } else questionBank.lastIndex
            isAnswered(currentIndex)
            updateQuestion()

        }

        updateQuestion()

    }

    private fun updateQuestion() {
        val questionTextResId =
            questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId: Int

        if (userAnswer == correctAnswer) {
            messageResId = R.string.correct_toast
            currentScore++
        } else {
            messageResId = R.string.incorrect_toast
        }
        if (questionBank.size == lockedQuestions.size) {
            Toast.makeText(
                this, "${(currentScore / questionBank.size * 100).toInt()}%"
                ,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        }
        trueButton.isEnabled = false
        falseButton.isEnabled = false
        questionBank[currentIndex].answered = true

    }

    private fun isAnswered(index: Int) {
        val isQuestionAnswered = questionBank[index].answered
        trueButton.isEnabled = !isQuestionAnswered
        falseButton.isEnabled = !isQuestionAnswered
    }
}