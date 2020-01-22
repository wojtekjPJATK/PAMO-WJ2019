package com.example.zwiekszmase.repository

import com.example.zwiekszmase.model.Meal

class DietDataSource {

    companion object {
        fun createDataSet(): ArrayList<Meal>{
            val list = ArrayList<Meal>()
            list.add(Meal("Pizza", "Najlepsze źrodło tłuszczy i weglowodanów", "https://www.oetker.pl/Recipe/Recipes/oetker.pl/pl-pl/miscallaneous/image-thumb__51050__RecipeDetailsLightBox/pizza-domowa.jpg"))
            list.add(Meal("Burger", "Pełnowartościowe białko", "https://pizzaportal.pl/i/wp-content/uploads/2019/02/burger.jpg"))
            list.add(Meal("Kebab", "Tylko z sosem czosnkowym", "https://d-art.ppstatic.pl/kadry/k/r/1/67/c6/5ae18d345d928_o_medium.jpg"))
            list.add(Meal("Pączek", "Wypełniony miłością", "https://res.cloudinary.com/dj484tw6k/f_auto,q_auto,fl_progressive,c_pad,b_white,w_356,h_356/v1499888782/be/81591.jpg"))
            list.add(Meal("Stek", "Podstawa dobrej masy", "https://cdn.shopify.com/s/files/1/0084/6158/2372/products/product_24_560x.jpg"))
            return list
        }
    }
}