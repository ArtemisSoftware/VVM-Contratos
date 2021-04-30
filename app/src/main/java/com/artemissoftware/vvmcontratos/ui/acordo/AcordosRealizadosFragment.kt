package com.artemissoftware.vvmcontratos.ui.acordo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.databinding.FragmentAcordoBinding
import com.artemissoftware.vvmcontratos.databinding.FragmentAcordosRealizadosBinding
import com.artemissoftware.vvmcontratos.ui.ContratoActivity
import com.artemissoftware.vvmcontratos.ui.acordo.adaptadores.OnAcordoListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AcordosRealizadosFragment : Fragment(R.layout.fragment_acordos_realizados), OnAcordoListener {

    private val viewModel : AcordoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAcordosRealizadosBinding.bind(view)
        binding.setLifecycleOwner(this)
        binding.setViewmodel(viewModel)
        binding.listener = this

        viewModel.obterAcordosRealizados()
    }

    override fun onAcordoClick(contrato: Contrato) {

        //TODO: gravar nas preferencias o identificador do acordo


        val intent = Intent(requireContext(), ContratoActivity::class.java)
        intent.putExtra("keyIdentifier", 1)
        startActivity(intent)

    }

}

