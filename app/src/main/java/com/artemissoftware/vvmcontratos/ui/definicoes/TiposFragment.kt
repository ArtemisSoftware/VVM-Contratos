package com.artemissoftware.vvmcontratos.ui.definicoes

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tipos.*
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class TiposFragment : Fragment(R.layout.fragment_tipos) {


    private val viewModel : DefinicoesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





        //viewModel.obterTipo(MetodoTipos.EMPRESAS_VIVAMAIS)
        viewModel.obterResumoTipo()
        subscreverObservadores()

    }

    private fun subscreverObservadores() {

        lifecycleScope.launchWhenStarted {
            viewModel.evento.collect { evento ->

                when(evento) {

                    is BaseViewModel.Evento.Sucesso -> {
                        loading.isVisible = false

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
    }

}

