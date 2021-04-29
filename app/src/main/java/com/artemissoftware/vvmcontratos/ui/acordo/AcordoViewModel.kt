package com.artemissoftware.vvmcontratos.ui.acordo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.artemissoftware.vvmcontratos.api.Metodo
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.repositorios.ContratoRepositorio
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
    private val contratoRepositorio: ContratoRepositorio,
    private val redeRepositorio: RedeRepositorio,
    private val tipoRepositorio: TipoRepositorio,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {

    private val _mensagem = MutableStateFlow<EventoAcordo>(EventoAcordo.SemEstado)
    val mensagem: StateFlow<EventoAcordo> = _mensagem


    private lateinit var dadosCliente: DadosClienteDto;

    val tiposContratos: LiveData<List<Tipo>> = tipoRepositorio.obteTipo(MetodoTipos.TIPOS_CONTRATOS)
    val tiposEmpresas: LiveData<List<Tipo>> = tipoRepositorio.obteTipo(MetodoTipos.EMPRESAS_VIVAMAIS)
    val tiposMarcas: LiveData<List<Tipo>> = tipoRepositorio.obteTipo(MetodoTipos.MARCAS)


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


    fun obterDadosContrato(idUtilizador: String, nif: String, tipoContrato: Tipo, empresa: Tipo, marca: Tipo) {

        _evento.value = Evento.Loading

        viewModelScope.launch(dispatcherProvider.io) {

            try {
                coroutineScope {

                    val respostasMoradas = async { redeRepositorio.obterMoradasCliente(nif, empresa.descricao) }
                    val respostaNumeroContrato = async { redeRepositorio.obterNumeroContrato (empresa.id.toString(), marca.id.toString()) }

                    try {
                        val moradas = respostasMoradas.await()
                        val numeroContrato = respostaNumeroContrato.await()

                        contratoRepositorio.inserirDadosContrato(idUtilizador, nif, tipoContrato, empresa, marca, dadosCliente, moradas.dados!!, numeroContrato.dados!!)

                        _evento.value = Evento.Sucesso("LTC has  ")

                    } catch (e: Exception) {
                        _evento.value = Evento.Erro(e.message!!)
                    }

                }

            }
            catch (e: Exception) {
                _evento.value = Evento.Erro(e.message!!)
            }
        }
    }


    sealed class EventoAcordo {
        class ObterDadosContrato(val estado: String) : EventoAcordo()
        object SemEstado : EventoAcordo()
    }

}