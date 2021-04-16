package com.artemissoftware.vvmcontratos.ui.definicoes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.vvmcontratos.repositorios.RedeRepositorio
import com.artemissoftware.vvmcontratos.utils.DispatcherProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.round

class DefinicoesViewModel  @ViewModelInject constructor(
    private val redeRepositorio: RedeRepositorio,
    private val dispatcherProvider: DispatcherProvider
): ViewModel(){




    fun obterTipo(tipo: String) {

        viewModelScope.launch(dispatcherProvider.io) {


            val ratesResponse = redeRepositorio.obterTipo(metodo = tipo)

            val i = 0

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
        }
    }

}