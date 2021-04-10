package com.artemissoftware.vvmcontratos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()



        //appBarConfiguration = AppBarConfiguration(setOf(R.id.clienteFragment, R.id.observacaoFragment))
        appBarConfiguration = AppBarConfiguration(navController.graph)

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        //toolbar.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.acordoFragment) {

                bottom_nav.visibility = View.GONE
            } else {
                toolbar.visibility = View.VISIBLE
            }
        }

        //possivel alternativa
//https://stackoverflow.com/questions/62551658/hide-bottom-navigation-view-in-fragment
        bottom_nav.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (item.itemId == R.id.clienteFragment) {
//            val action = NavGraphDirections.actionGlobalTermsFragment()
//            navController.navigate(action)
//            true
//        } else {
//            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}