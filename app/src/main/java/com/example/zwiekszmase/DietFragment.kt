package com.example.zwiekszmase


import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zwiekszmase.repository.DietDataSource
import com.example.zwiekszmase.repository.ResultRepository
import kotlinx.android.synthetic.main.fragment_diet.*

/**
 * A simple [Fragment] subclass.
 */
class DietFragment : Fragment() {

    private lateinit var mealAdapter: MealAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        addDataSet()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diet, container, false)
    }

    private fun addDataSet() {
        val data = DietDataSource.createDataSet()
        mealAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        dietRecycler.apply {
            layoutManager = LinearLayoutManager(this@DietFragment.activity)
            val itemDecoration = ItemDecoration(30)
            addItemDecoration(itemDecoration)
            mealAdapter = MealAdapter()
            adapter = mealAdapter
        }
    }


}
