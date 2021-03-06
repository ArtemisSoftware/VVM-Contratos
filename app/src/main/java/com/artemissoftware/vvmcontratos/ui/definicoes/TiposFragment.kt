package com.artemissoftware.vvmcontratos.ui.definicoes

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.ui.onNavDestinationSelected
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import com.artemissoftware.vvmcontratos.ui.definicoes.adaptadores.TipoAdaptador
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tipos.*
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class TiposFragment : Fragment(R.layout.fragment_tipos) {


    private val viewModel : DefinicoesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)

        recyclerView.apply {
            adapter = TipoAdaptador()
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        subscreverObservadores()
    }



    private fun subscreverObservadores() {

        lifecycleScope.launchWhenStarted {
            viewModel.evento.collect { evento ->

                when(evento) {

                    is BaseViewModel.Evento.Sucesso -> {
                        loading.isVisible = false
                        //viewModel.obterResumoTipo()

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



        viewModel.obterResumosTipo().observe(viewLifecycleOwner) { it ->
            (recyclerView.adapter as TipoAdaptador).submitList(it)
        }


    }





    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.tipos_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {

            R.id.item_recarregar_tipos -> {

//                viewModel.obterTipo(MetodoTipos.TIPOS_CONTRATOS)
                viewModel.recarregarTipos()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }




}

