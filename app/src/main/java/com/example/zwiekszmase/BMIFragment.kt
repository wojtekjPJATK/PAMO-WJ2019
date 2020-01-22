package com.example.zwiekszmase


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zwiekszmase.repository.ResultRepository
import kotlinx.android.synthetic.main.fragment_bmi.*
import kotlinx.android.synthetic.main.fragment_bmi.view.*


/**
 * A simple [Fragment] subclass.
 */
class BMIFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_bmi, container, false)

        view.caluculateButton.setOnClickListener {
            val weight: Double = weightText.getText().toString().toDouble()
            val height: Double = heightText.getText().toString().toDouble()
            val heightInM: Double = height.div(100)
            val heightSquare: Double = heightInM * heightInM
            val bmi: Double = weight / heightSquare
            bmiText.setText(String.format("%.2f", bmi))

            when (bmi) {
                in 0.0..18.5 -> scaleText.setText(R.string.bmi_underweight)
                in 18.5..25.0 -> scaleText.setText(R.string.bmi_normal_weight)
                else -> scaleText.setText(R.string.bmi_overweight)
            }
            var repo = ResultRepository
            repo.add(
                ageText.getText().toString().toInt(),
                radioFemale.isChecked(),
                weight,
                height
            )
        }
        return view
    }
}
