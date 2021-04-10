package com.artemissoftware.vvmcontratos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()


        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.acordoFragment) {

                bottom_nav.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
            }
        }


        bottom_nav.setupWithNavController(navController)
    }

}