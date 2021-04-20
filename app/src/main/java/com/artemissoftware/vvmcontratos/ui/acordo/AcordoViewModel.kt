package com.artemissoftware.vvmcontratos.ui.acordo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.repositorios.TipoRepositorio
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import com.artemissoftware.vvmcontratos.utils.DispatcherProvider

class AcordoViewModel @ViewModelInject constructor(
    private val tipoRepositorio: TipoRepositorio,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {

    val jojo: LiveData<List<Tipo>> = tipoRepositorio.obteTipo(MetodoTipos.EMPRESAS_VIVAMAIS.descricao)



}