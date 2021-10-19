package com.artemissoftware.vvmcontratos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.artemissoftware.vvmcontratos.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_contrato.*

@AndroidEntryPoint
class ContratoActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()



        appBarConfiguration = AppBarConfiguration(navController.graph)

        setupActionBarWithNavController(navController, appBarConfiguration)

//        setSupportActionBar(toolbar)
//        setupActionBarWithNavController(navController, appBarConfiguration)

        //possivel alternativa
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if(destination.id == R.id.acordoFragment) {
//
//                bottom_nav.visibility = View.GONE
//            } else {
//                bottom_nav.visibility = View.VISIBLE
//            }
//        }
//
//
////https://stackoverflow.com/questions/62551658/hide-bottom-navigation-view-in-fragment
//        //---
//        bottom_nav.setupWithNavController(navController)
//
//

          navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.registoMoradaFragment) {

                fabMenu.visibility = View.GONE
                bottom_nav.visibility = View.GONE
            } else {
                fabMenu.visibility = View.VISIBLE
                bottom_nav.visibility = View.VISIBLE
            }
        }


        fabMorada.setOnClickListener {
            navController.navigateUp() // to clear previous navigation history
            navController.navigate(R.id.registoMoradaFragment)
        }

    }
}