package com.example.zwiekszmase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.zwiekszmase.model.Meal
import kotlinx.android.synthetic.main.meal_item.view.*

class MealAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Meal> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MealViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.meal_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MealViewHolder -> {holder.bind(items.get(position))}
        }
    }

    fun submitList(mealList: List<Meal>) {
        items = mealList
    }

    class MealViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val mealImage: ImageView = itemView.meal_image
        val mealName: TextView = itemView.meal_name
        val mealBody: TextView = itemView.meal_body

        fun bind(meal: Meal) {
            mealName.setText(meal.name)
            mealBody.setText(meal.body)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(meal.image)
                .into(mealImage)
        }
    }
}


