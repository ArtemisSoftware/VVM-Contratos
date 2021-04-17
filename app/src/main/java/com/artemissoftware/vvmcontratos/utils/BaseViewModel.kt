package com.artemissoftware.vvmcontratos.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel (
    private val dispatcherProvider: DispatcherProvider
): ViewModel(){


    protected val _evento = MutableStateFlow<Evento>(Evento.SemEstado)
    val evento: StateFlow<Evento> = _evento

    sealed class Evento {

        class Sucesso(val mensagem: String): Evento()
        class Erro(val mensagem: String): Evento()
        object Loading : Evento()
        object SemEstado : Evento()
    }

}