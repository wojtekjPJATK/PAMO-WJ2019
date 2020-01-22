package com.example.zwiekszmase


import android.graphics.Color
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.zwiekszmase.model.Question
import com.example.zwiekszmase.repository.QuestionDataSource
import com.google.android.material.snackbar.Snackbar
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask


/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        var button: Button = v as Button
        if (button.text == currentQuestion.validAnswer) {
            button.setBackgroundColor(Color.GREEN)
            score += 1
            Timer("NextQuestion").schedule(timerTask{ nextQuestion() }, 300)
        } else {
            button.setBackgroundColor(Color.RED)
        }
    }

    private fun nextQuestion() {
        val scoreString: String = getString(R.string.quiz_score) + " " + score.toString()
        scoreTextView.text = scoreString
        if(questions.hasNext()) currentQuestion = questions.next()
        else {
            return endQuiz()
        }
        val answers = currentQuestion.answers.shuffled().listIterator()
        answerButtons.forEach {
            it.setBackgroundColor(Color.GRAY)
            it.text = answers.next()
        }
        questionTextView.text = currentQuestion.question
    }

    private fun endQuiz() {
        answerButtons.forEach {
            it.setOnClickListener(null)
        }
        Looper.prepare()
        Snackbar.make(view!!, "Gratulacje! Masa jest z Tobą", Snackbar.LENGTH_LONG).show()
    }

    private var score: Int = 0
    private lateinit var questionTextView: TextView
    private lateinit var answerButtons: ArrayList<Button>
    private lateinit var scoreTextView: TextView
    private var questions = QuestionDataSource.createDataSet().iterator()
    private lateinit var currentQuestion: Question


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_quizz, container, false)
        initializeQuizz(view)
        return view
    }

    private fun initializeQuizz(view: View) {
        answerButtons = ArrayList()
        var button: Button = view.findViewById<Button>(R.id.answer_a)
        answerButtons.add(button)
        button = view.findViewById(R.id.answer_b)
        answerButtons.add(button)
        button = view.findViewById(R.id.answer_c)
        answerButtons.add(button)
        button = view.findViewById(R.id.answer_d)
        answerButtons.add(button)

        answerButtons.forEach {
            it.setOnClickListener(this)
        }
        scoreTextView = view.findViewById(R.id.question_score)
        questionTextView = view.findViewById(R.id.question_ask)
        nextQuestion()
    }

}
