package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.utils.Recurso

interface RedeRepositorio {

    suspend fun obterTipo(metodo: String): Recurso<ListagemDto<TipoDto>>



    suspend fun obterDadosCliente(nif: String): Recurso<DadosClienteDto>
}