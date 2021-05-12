package com.artemissoftware.vvmcontratos.ui.cliente

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.artemissoftware.vvmcontratos.MainActivity
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.databinding.FragmentAcordoBinding
import com.artemissoftware.vvmcontratos.databinding.FragmentClienteBinding
import com.artemissoftware.vvmcontratos.ui.ContratoViewModel
import com.artemissoftware.vvmcontratos.ui.acordo.AcordoViewModel
import com.artemissoftware.vvmcontratos.ui.definicoes.adaptadores.TipoAdaptador
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_cliente.*
import kotlinx.android.synthetic.main.fragment_tipos.*

@AndroidEntryPoint
class ClienteFragment : Fragment(R.layout.fragment_cliente) {

    private lateinit var navController: NavController

    private lateinit var binding: FragmentClienteBinding

    private val viewModel : ContratoViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        //setHasOptionsMenu(true)

        binding = FragmentClienteBinding.bind(view)
        binding.setLifecycleOwner(this)


        subscreverObservadores()
    }

    private fun subscreverObservadores() {


        viewModel.obterContrato(1).observe(viewLifecycleOwner) { it ->

            if(it == null){
                constraint_novo_cliente.visibility = View.VISIBLE
                constraint_cliente.visibility = View.GONE
            }
            else{
                constraint_novo_cliente.visibility = View.GONE
                constraint_cliente.visibility = View.VISIBLE
                binding.registo = it
            }
        }
    }



//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.contrato_menu, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
//    }
}
