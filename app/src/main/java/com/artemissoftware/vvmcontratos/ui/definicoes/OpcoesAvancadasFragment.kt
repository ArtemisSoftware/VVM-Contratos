package com.artemissoftware.vvmcontratos.ui.definicoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.artemissoftware.vvmcontratos.R
import com.artemissoftware.vvmcontratos.databinding.FragmentOpcoesAvancadasBinding


class OpcoesAvancadasFragment : Fragment(R.layout.fragment_opcoes_avancadas) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val binding = FragmentOpcoesAvancadasBinding.bind(view)

        binding.lnrLytTipos.setOnClickListener {
            val action = OpcoesAvancadasFragmentDirections.actionOpcoesAvancadasFragmentToTiposFragment()
            findNavController().navigate(action)
        }
    }

}

