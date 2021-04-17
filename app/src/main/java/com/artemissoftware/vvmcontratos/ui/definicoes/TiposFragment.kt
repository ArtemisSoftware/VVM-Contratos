package com.artemissoftware.vvmcontratos.ui.definicoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TiposFragment : Fragment(R.layout.fragment_tipos) {


    private val viewModel : DefinicoesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.obterTipo(MetodoTipos.EMPRESAS_VIVAMAIS)
    }

}

