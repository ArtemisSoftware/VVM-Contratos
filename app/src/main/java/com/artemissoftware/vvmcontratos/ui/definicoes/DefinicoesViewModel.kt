package com.artemissoftware.vvmcontratos.ui.definicoes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.vvmcontratos.api.Metodo
import com.artemissoftware.vvmcontratos.api.MetodoTipos
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorio
import com.artemissoftware.vvmcontratos.utils.BaseViewModel
import com.artemissoftware.vvmcontratos.utils.DispatcherProvider
import com.artemissoftware.vvmcontratos.utils.Recurso
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.round

class DefinicoesViewModel @ViewModelInject constructor(
    private val redeRepositorio: RedeRepositorio,
    private val dispatcherProvider: DispatcherProvider
): BaseViewModel(dispatcherProvider) {




    fun obterTipo(tipo: Metodo) {

        viewModelScope.launch(dispatcherProvider.io) {

            _evento.value = Evento.Loading

            val resposta = redeRepositorio.obterTipo(metodo = tipo.metodoApi)

            when(resposta) {

                is Recurso.Erro -> _evento.value = Evento.Erro(resposta.messagem!!)

                is Recurso.Sucesso -> {

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




//    sealed class CurrencyEvent {
//        class Success(val resultText: String): CurrencyEvent()
//        class Failure(val errorText: String): CurrencyEvent()
//        object Loading : CurrencyEvent()
//        object Empty : CurrencyEvent()
//    }
//
//
//
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