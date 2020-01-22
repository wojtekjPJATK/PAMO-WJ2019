package com.example.zwiekszmase.repository

import com.example.zwiekszmase.model.Result
import java.time.LocalTime

object ResultRepository {
    private var results = ArrayList<Result>()

    init {
        print("Repository initialised")
        results.clear()
    }

    fun add(age: Int, woman: Boolean, weight: Double, height: Double) {
        var timeNow = LocalTime.now().toString().split(".")[0]
        var result = Result(weight, height, woman, age, timeNow)
        results.add(result)
    }

    fun all(): ArrayList<Result> {
        return results
    }

    fun chartData(): String {
        var resultStringBuilder = StringBuilder()
        results.forEach {
            resultStringBuilder.append("['").append(it.time).append("',").append(it.weight).append("],")
        }
        return resultStringBuilder.toString()
    }
}