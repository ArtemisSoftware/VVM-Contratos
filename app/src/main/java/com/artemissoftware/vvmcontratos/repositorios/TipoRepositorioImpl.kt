package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.dao.AtualizacaoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.TipoDao
import com.artemissoftware.vvmcontratos.utils.mapeamento.map
import com.artemissoftware.vvmcontratos.utils.mapeamento.map_
import javax.inject.Inject

class TipoRepositorioImpl @Inject constructor(private val atualizacaoDao: AtualizacaoDao, private val tipoDao: TipoDao):TipoRepositorio{


    override suspend fun inserirTipos(tipos: ListagemDto<TipoDto>) {

        //mapeamento
        val mapeamento2= tipos.map()
        val mapeamento = tipos.map_()

        //val lolo = mapeamento.map(tipos)
        //eliminar
        atualizacaoDao.eliminar(mapeamento2.descricao)
        //inserir
        atualizacaoDao.inserir(mapeamento2)
        tipoDao.inserir(mapeamento)
    }


}