package com.example.route.route_task.ui.product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.route.route_task.R
import com.example.route.route_task.ui.product.fragment.ProductsFragment

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)


        val productsFragment = ProductsFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, productsFragment).commit()
    }

}