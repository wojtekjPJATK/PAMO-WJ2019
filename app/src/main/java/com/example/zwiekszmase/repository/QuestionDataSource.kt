package com.example.zwiekszmase.repository

import com.example.zwiekszmase.model.Meal
import com.example.zwiekszmase.model.Question

class QuestionDataSource {

    companion object {
        fun createDataSet(): ArrayList<Question>{
            val list = ArrayList<Question>()
            var answers = listOf("Pizza", "Owsianka", "Jabłko", "Pomarańcz")
            list.add(Question("Który posiłek ma najwięcej kalorii?", answers, "Pizza"))
            answers = listOf("Bicki", "Klata", "Nogi", "Barki")
            list.add(Question("W co idzie masa od pączków?", answers, "Bicki"))
            answers = listOf("1", "4", "5", "wszystkie")
            list.add(Question("Ile posiłków dziennie należy spożywać?", answers, "wszystkie"))
            return list
        }
    }
}