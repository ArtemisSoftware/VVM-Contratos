package com.artemissoftware.vvmcontratos.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import com.artemissoftware.vvmcontratos.repositorios.ContratoRepositorio
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorio
import com.artemissoftware.vvmcontratos.ui.cliente.modelos.ClienteRegisto
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import com.artemissoftware.vvmcontratos.utils.DispatcherProvider

class ContratoViewModel @ViewModelInject constructor(
    private val contratoRepositorio: ContratoRepositorio,
    private val redeRepositorio: RedeRepositorio,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {

    var cliente: LiveData<ClienteRegisto>? = null;

    fun obterContrato(idContrato: Int) = contratoRepositorio.obterCliente(idContrato)
}