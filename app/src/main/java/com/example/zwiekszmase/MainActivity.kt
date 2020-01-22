package com.example.zwiekszmase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var homeFragment: HomeFragment
    lateinit var bmiFragment: BMIFragment
    lateinit var dietFragment: DietFragment
    lateinit var chartFragment: ChartFragment
    lateinit var quizFragment: QuizFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botNav: BottomNavigationView = findViewById(R.id.bot_navbar)

        homeFragment = HomeFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()

        botNav.setOnNavigationItemSelectedListener { menuItem ->

            when(menuItem.itemId) {

                R.id.tabbar_home -> {

                    homeFragment = HomeFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tabbar_bmi -> {

                    bmiFragment = BMIFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, bmiFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tabbar_kalorie -> {

                    dietFragment = DietFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, dietFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tabbar_chart -> {
                    chartFragment = ChartFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, chartFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tabbar_quiz -> {
                    quizFragment = QuizFragment()
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_layout, quizFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener true
            }
        }
    }
}
