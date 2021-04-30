package com.artemissoftware.vvmcontratos.repositorios

import androidx.lifecycle.LiveData
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.NumeroContratoDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo


interface ContratoRepositorio {

    suspend fun inserirDadosContrato(idUtilizador: String, nif: String, tipoContrato: Tipo, empresa: Tipo, marca: Tipo,
                                     cliente: DadosClienteDto, moradas: MoradaDto, numeroContrato: NumeroContratoDto)


    fun obterAcordosRealizados(): LiveData<List<Contrato>>

}