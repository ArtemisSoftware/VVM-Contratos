package com.artemissoftware.vvmcontratos.repositorios

import androidx.lifecycle.LiveData
import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.dao.AtualizacaoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.TipoDao
import com.artemissoftware.vvmcontratos.ui.definicoes.modelos.ResumoTipo
import com.artemissoftware.vvmcontratos.utils.mapeamento.map
import com.artemissoftware.vvmcontratos.utils.mapeamento.mapDetalhe
import com.artemissoftware.vvmcontratos.utils.mapeamento.map_
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TipoRepositorioImpl @Inject constructor(private val atualizacaoDao: AtualizacaoDao, private val tipoDao: TipoDao):TipoRepositorio{


    override suspend fun inserirTipos(tipos: ListagemDto<TipoDto>) {

        //mapeamento
        val mapeamento2= tipos.map()
        val mapeamento = tipos.map_()
        val detalhes = tipos.mapDetalhe()

        //val lolo = mapeamento.map(tipos)
        //eliminar
        //atualizacaoDao.eliminar(mapeamento2.descricao)
        //inserir
        atualizacaoDao.inserir(mapeamento2)
        tipoDao.inserir(mapeamento)
    }

    override fun obterResumosTipo():  LiveData<List<ResumoTipo>> {
        return tipoDao.obterResumos()
    }


}