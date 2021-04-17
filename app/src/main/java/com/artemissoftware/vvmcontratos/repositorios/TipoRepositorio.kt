package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto

interface TipoRepositorio {


    suspend fun inserirTipos(tipos: ListagemDto<TipoDto>)

}