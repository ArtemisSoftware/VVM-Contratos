package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.NumeroContratoDto


interface ContratoRepositorio {

    suspend fun inserirDadosContrato(cliente: DadosClienteDto, moradas: MoradaDto, numeroContrato: NumeroContratoDto)
}