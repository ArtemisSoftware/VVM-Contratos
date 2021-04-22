package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.NumeroContratoDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.utils.Recurso

interface RedeRepositorio {

    suspend fun obterTipo(metodo: String): Recurso<ListagemDto<TipoDto>>



    suspend fun obterDadosCliente(nif: String): Recurso<DadosClienteDto>

    suspend fun obterMoradasCliente(nif: String, empresa: String): Recurso<MoradaDto>

    suspend fun obterNumeroContrato(idEmpresa: String, idMarca: String): Recurso<NumeroContratoDto>
}