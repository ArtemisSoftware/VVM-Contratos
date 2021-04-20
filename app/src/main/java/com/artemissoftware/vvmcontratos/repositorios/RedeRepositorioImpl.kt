package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.ContratosApi
import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.utils.Recurso
import com.himanshurawat.hasher.HashType
import com.himanshurawat.hasher.Hasher
import javax.inject.Inject

class RedeRepositorioImpl @Inject constructor(
    private val api: ContratosApi
):RepositorioBase(), RedeRepositorio{


    override suspend fun obterTipo(metodo: String): Recurso<ListagemDto<TipoDto>> {
        return getResult { api.obterTipo(metodo) }
    }

    override suspend fun obterDadosCliente(nif: String): Recurso<DadosClienteDto> {

        return getResult { api.obterDadosCliente(nif, Hasher.hash(nif,HashType.MD5)) }
    }
}