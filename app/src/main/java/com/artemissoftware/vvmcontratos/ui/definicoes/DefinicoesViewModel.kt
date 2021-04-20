package com.artemissoftware.vvmcontratos.ui.definicoes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.artemissoftware.vvmcontratos.api.Metodo
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorio
import com.artemissoftware.vvmcontratos.repositorios.TipoRepositorio
import com.artemissoftware.vvmcontratos.ui.definicoes.modelos.ResumoTipo
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import com.artemissoftware.vvmcontratos.utils.DispatcherProvider
import com.artemissoftware.vvmcontratos.utils.Recurso
import kotlinx.coroutines.launch

class DefinicoesViewModel @ViewModelInject constructor(
    private val redeRepositorio: RedeRepositorio,
    private val tipoRepositorio: TipoRepositorio,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {

    //    var _allWords : LiveData<List<ResumoTipo>>()
//    val allWords: LiveData<List<ResumoTipo>>
//        get() = tipoRepositorio.obterResumoTipo().flowOn(dispatcherProvider.main)
//            .asLiveData(context = viewModelScope.coroutineContext)




    fun obterResumosTipo() = tipoRepositorio.obterResumosTipo()



    fun obterTipo(tipo: Metodo) {

        viewModelScope.launch(dispatcherProvider.io) {

            _evento.value = Evento.Loading

            val resposta = redeRepositorio.obterTipo(metodo = tipo.metodoApi)

            when(resposta) {

                is Recurso.Erro -> _evento.value = Evento.Erro(resposta.messagem!!)

                is Recurso.Sucesso -> {

                    resposta.dados?.let {
                        tipoRepositorio.inserirTipos(it)
                        _evento.value = Evento.Sucesso("lolo")
                    }
                }

            }
        }
    }



}