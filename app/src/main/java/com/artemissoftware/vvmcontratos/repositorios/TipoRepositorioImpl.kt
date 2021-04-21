package com.artemissoftware.vvmcontratos.repositorios

import androidx.lifecycle.LiveData
import com.artemissoftware.vvmcontratos.api.Metodo
import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.dao.AtualizacaoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.TipoDao
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.ui.definicoes.modelos.ResumoTipo
import com.artemissoftware.vvmcontratos.utils.mapeamento.map
import com.artemissoftware.vvmcontratos.utils.mapeamento.mapDetalhe
import com.artemissoftware.vvmcontratos.utils.mapeamento.map_
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TipoRepositorioImpl @Inject constructor(private val atualizacaoDao: AtualizacaoDao, private val tipoDao: TipoDao):TipoRepositorio{


    override suspend fun inserirTipos(registos: ListagemDto<TipoDto>) {

        //mapeamento
        val atualizacao= registos.map()
        val tipos = registos.map_()
        val detalhes = registos.mapDetalhe()

        //val lolo = mapeamento.map(tipos)
        //eliminar
        //atualizacaoDao.eliminar(mapeamento2.descricao)
        //inserir
        atualizacaoDao.inserir(atualizacao)
        tipoDao.inserir(tipos)
    }


    override suspend fun recarregarTipos(registos: List<ListagemDto<TipoDto>>) {

        registos.forEach{

            val atualizacao= it.map()
            val tipos = it.map_()

            atualizacaoDao.eliminar(atualizacao.descricao)
            atualizacaoDao.inserir(atualizacao)
            tipoDao.inserir(tipos)
        }

    }


    override fun obterResumosTipo():  LiveData<List<ResumoTipo>> {
        return tipoDao.obterResumos()
    }

    override fun obteTipo(metodo: Metodo): LiveData<List<Tipo>> {
        return tipoDao.obterTipo(metodo.metodoApi)
    }


}