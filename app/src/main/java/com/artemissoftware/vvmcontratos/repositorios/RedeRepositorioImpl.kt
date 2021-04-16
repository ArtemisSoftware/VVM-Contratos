package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.ContratosApi
import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.utils.Recurso
import javax.inject.Inject

class RedeRepositorioImpl @Inject constructor(
    private val api: ContratosApi
):RepositorioBase(), RedeRepositorio{

    override suspend fun obterTipo(metodo: String): Recurso<ListagemDto<TipoDto>> {

        return getResult { api.obterTipo(metodo) }
    }
}