package com.bignerdranch.android.geoquiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.geoquiz.databinding.ActivityCheatBinding

private const val EXTRA_ANSWER_IS_TRUE = "com.bignerchanch.android.geoquiz.answer_is_true"

class CheatActivity : AppCompatActivity() {

    private lateinit var binding : ActivityCheatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object{
        fun newIntent(packageContext : Context, answerIsTrue : Boolean) : Intent {
            return Intent(packageContext , CheatActivity::class.java).apply{
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}