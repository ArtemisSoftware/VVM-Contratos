package com.artemissoftware.vvmcontratos.ui.acordo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.databinding.FragmentAcordoBinding
import com.artemissoftware.vvmcontratos.databinding.FragmentAcordosRealizadosBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AcordosRealizadosFragment : Fragment(R.layout.fragment_acordos_realizados) {

    private val viewModel : AcordoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAcordosRealizadosBinding.bind(view)
        binding.setLifecycleOwner(this)
        binding.setViewmodel(viewModel)

        viewModel.obterAcordosRealizados()
    }

}

