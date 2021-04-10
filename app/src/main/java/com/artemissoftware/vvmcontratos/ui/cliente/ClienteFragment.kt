package com.artemissoftware.vvmcontratos.ui.cliente

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.artemissoftware.vvmcontratos.MainActivity
import com.artemissoftware.vvmcontratos.R
import kotlinx.android.synthetic.main.activity_main.*


class ClienteFragment : Fragment(R.layout.fragment_cliente) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.contrato_menu, menu)

    }

}
