package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.dao.AtualizacaoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.TipoDao
import javax.inject.Inject

class TipoRepositorioImpl @Inject constructor(atualizacaoDao: AtualizacaoDao, tipoDao: TipoDao):TipoRepositorio{


    override suspend fun inserirTipos(tipos: ListagemDto<TipoDto>) {

        //mapeamento

        //eliminar

        //inserir

    }


}