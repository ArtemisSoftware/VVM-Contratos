package com.artemissoftware.vvmcontratos.ui.acordo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.artemissoftware.vvmcontratos.api.Metodo
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorio
import com.artemissoftware.vvmcontratos.repositorios.TipoRepositorio
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import com.artemissoftware.vvmcontratos.utils.DispatcherProvider
import com.artemissoftware.vvmcontratos.utils.Recurso
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AcordoViewModel @ViewModelInject constructor(
    private val redeRepositorio: RedeRepositorio,
    private val tipoRepositorio: TipoRepositorio,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {

    private val _mensagem = MutableStateFlow<EventoAcordo>(EventoAcordo.SemEstado)
    val mensagem: StateFlow<EventoAcordo> = _mensagem


    private lateinit var dadosCliente: DadosClienteDto;

    val tiposContratos: LiveData<List<Tipo>> = tipoRepositorio.obteTipo(MetodoTipos.TIPOS_CONTRATOS)



    fun obterDadosCliente(nif: String) {

        viewModelScope.launch(dispatcherProvider.io) {

            _evento.value = Evento.Loading

            val resposta = redeRepositorio.obterDadosCliente(nif)

            when(resposta) {

                is Recurso.Erro -> _evento.value = Evento.Erro(resposta.messagem!!)

                is Recurso.Sucesso -> {

                    resposta.dados?.let {
                        dadosCliente = it

                        var texto = "Novo cliente"

                        if(it.clientes.isNotEmpty()){
                            texto = ""
                        }

                        _mensagem.value = EventoAcordo.ObterDadosContrato(texto)
                    }
                }

            }
        }
    }


//    fun obterDadosContrato(nif: String) {
//
//        viewModelScope.launch(dispatcherProvider.io) {
//            try {
//                coroutineScope {
//
//                    _evento.value = Evento.Loading
//
//                    val call1 = async { redeRepositorio.obterDadosCliente(nif) }
////                    val call2 = async { cryptoCurrencyRepository.getCoinData("DOGE") }
////                    val call3 = async { cryptoCurrencyRepository.getError() }
//
//                    try {
//                        val ltc = call1.await()
////                        val doge = call2.await()
////                        val error = call3.await()
//
//                        _evento.value = Evento.Sucesso("LTC has  ")
//
//                    } catch (e: Exception) {
//                        _evento.value = Evento.Erro(e.message!!)
//                    }
//
//                }
//
//            }
//            catch (e: Exception) {
//                _evento.value = Evento.Erro(e.message!!)
//            }
//        }
//    }


    sealed class EventoAcordo {
        class ObterDadosContrato(val estado: String) : EventoAcordo()
        object SemEstado : EventoAcordo()
    }

}