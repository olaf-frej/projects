package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.bignerdranch.android.geoquiz.databinding.ActivityMainBinding

//LogCat [Activity Life Cycle] - EXAM QUESTION
//Assigned at complilation "Access outside activity"
private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quizViewModel : QuizViewModel by viewModels()
    //Question Bank - EXAM QUESTION


    //Creating App Instance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Activity Life Cycle - EXAM QUESTION
        //Different Types of Logs to debug
        Log.d(TAG, "onCreate() entered")
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Got a QuizViewModel : $quizViewModel")

        //R Class is the built-in class
        //binding.trueButton = findViewById(R.id.true_button)
        //binding. falseButton = findViewById(R.id.false_button)

        //True Button Trigger
        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }
        //False Button Trigger
        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }
        //Next Button Trigger
        binding.nextButton.setOnClickListener {
            //currentIndex = (currentIndex + 1) % questionBank.size

            //Update for View Model - Exam Question
            quizViewModel.moveToNext()
            updateQuestion()
        }


//       NEW FEATURE IMPLENTATION OF THE PREVIOUS BUTTON
        binding.prevButton.setOnClickListener {
            //currentIndex = (currentIndex + questionBank.size - 1) % questionBank.size

            //Update for View Model - Exam Question
            quizViewModel.moveToPrev()
            updateQuestion()
        }
        binding.cheatButton.setOnClickListener{
            //Start Cheat Activity
            //val intent = Intent( this, CheatActivity::class.java)
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent( this@MainActivity, answerIsTrue)
            startActivity(intent)
        }

        updateQuestion()
    }

    //Activity Life Cycle - EXAM QUESTION

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() entered")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() entered")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() entered")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() entered")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() entered")
    }

    private fun updateQuestion() {
        //UPDATING INDEX - HW IMPLEMENTATION
        //currentIndex = (currentIndex + questionBank.size) % questionBank.size
        //val questionTextResId = questionBank[currentIndex].textResId

        //View Model Update - Exam Question
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean){
        //val correctAnswer = questionBank[currentIndex].answer

        //View Model Update - Exam Question
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if(correctAnswer == userAnswer){
            R.string.correct_toast
        }else{
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }
}