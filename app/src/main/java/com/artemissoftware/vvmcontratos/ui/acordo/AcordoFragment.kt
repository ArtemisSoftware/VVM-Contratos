package com.artemissoftware.vvmcontratos.ui.acordo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.ui.definicoes.adaptadores.TipoAdaptador
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_acordo.*
import kotlinx.android.synthetic.main.fragment_tipos.*

@AndroidEntryPoint
class AcordoFragment : Fragment(R.layout.fragment_acordo) {

    private lateinit var navController: NavController

    private val viewModel : AcordoViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
//
//        toolbar.setupWithNavController(navController, appBarConfiguration)
        setHasOptionsMenu(true)


        viewModel.jojo.observe(viewLifecycleOwner) { it ->
            val i = 0
        }

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