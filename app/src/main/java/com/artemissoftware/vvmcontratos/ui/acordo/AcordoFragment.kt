package com.artemissoftware.vvmcontratos.ui.acordo

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.databinding.FragmentAcordoBinding
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import com.artemissoftware.vvmcontratos.utils.extensoes.obterTipoSelecionado
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_acordo.*
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class AcordoFragment : Fragment(R.layout.fragment_acordo) {

    private lateinit var navController: NavController

    private val viewModel : AcordoViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)

        setHasOptionsMenu(true)

        val binding = FragmentAcordoBinding.bind(view)
        binding.setLifecycleOwner(this)
        binding.setViewmodel(viewModel)

        subscreverObservadores()

        btn_validar.setOnClickListener {
            viewModel.obterDadosCliente(txt_nif.text.toString())
        }

        btn_iniciar.setOnClickListener {
            viewModel.obterDadosContrato("500005", txt_nif.text.toString(), spinner_tipo_contrato.obterTipoSelecionado(), spinner_empresa.obterTipoSelecionado(), spinner_marca.obterTipoSelecionado())
        }
    }


    private fun subscreverObservadores() {

        lifecycleScope.launchWhenStarted {
            viewModel.evento.collect { evento ->

                when (evento) {

                    is BaseViewModel.Evento.Sucesso -> {
                        loading.isVisible = false

                        val action = AcordoFragmentDirections.actionAcordoFragmentToClienteFragment()
                        findNavController().navigate(action)
                    }

                    is BaseViewModel.Evento.Erro -> {
                        loading.isVisible = false

                    }

                    is BaseViewModel.Evento.Loading -> {
                        loading.isVisible = true
                    }
                    else -> Unit
                }
            }

        }


        lifecycleScope.launchWhenStarted {

            viewModel.mensagem.collect { evento ->

                when (evento) {

                    is AcordoViewModel.EventoAcordo.ObterDadosContrato -> {
                        loading.isVisible = false
                        constraint_iniciar_contrato.visibility = View.VISIBLE
                        btn_validar.visibility = View.GONE
                        txt_tipo_cliente.text = evento.estado
                    }

                    else -> Unit
                }
            }
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