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



//                    val rates = ratesResponse.data!!.rates
//                    val rate: Double = getRateForCurrency(toCurrency, rates) as Double
//
//                    if(rate == null) {
//                        _conversion.value = CurrencyEvent.Failure("Unexpected error")
//                    } else {
//
//                        val convertedCurrency = round((fromAmount * rate * 100.0)) / 100
//                        _conversion.value = CurrencyEvent.Success("$fromAmount = $convertedCurrency $toCurrency")
//                    }
                }

            }
        }
    }



//    private val _conversion = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
//    val conversion: StateFlow<CurrencyEvent> = _conversion
//
//    fun convert(amountStr: String, toCurrency: String) {
//
//        val fromAmount = amountStr.toFloatOrNull()
//
//        if(fromAmount == null) {
//            _conversion.value = CurrencyEvent.Failure("Not a valid amount")
//            return
//        }
//
//        viewModelScope.launch(dispatcherProvider.io) {
//
//            _conversion.value = CurrencyEvent.Loading
//
//            when(val ratesResponse = repository.getRates(toCurrency)) {
//
//                is Resource.Error -> _conversion.value = CurrencyEvent.Failure(ratesResponse.message!!)
//
//                is Resource.Success -> {
//
//                    val rates = ratesResponse.data!!.rates
//                    val rate: Double = getRateForCurrency(toCurrency, rates) as Double
//
//                    if(rate == null) {
//                        _conversion.value = CurrencyEvent.Failure("Unexpected error")
//                    } else {
//
//                        val convertedCurrency = round((fromAmount * rate * 100.0)) / 100
//                        _conversion.value = CurrencyEvent.Success("$fromAmount = $convertedCurrency $toCurrency")
//                    }
//                }
//
//            }
//        }
//    }


}