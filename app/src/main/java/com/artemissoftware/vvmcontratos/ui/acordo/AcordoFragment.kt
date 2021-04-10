package com.artemissoftware.vvmcontratos.ui.acordo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.artemissoftware.vvmcontratos.R
import kotlinx.android.synthetic.main.fragment_acordo.*


class AcordoFragment : Fragment(R.layout.fragment_acordo) {

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
//
//        toolbar.setupWithNavController(navController, appBarConfiguration)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.main_menu, menu)

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
}