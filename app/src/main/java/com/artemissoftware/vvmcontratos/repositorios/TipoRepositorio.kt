package com.artemissoftware.vvmcontratos.repositorios

import androidx.lifecycle.LiveData
import com.artemissoftware.vvmcontratos.api.Metodo
import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.ui.definicoes.modelos.ResumoTipo
import kotlinx.coroutines.flow.Flow

interface TipoRepositorio {


    suspend fun inserirTipos(tipos: ListagemDto<TipoDto>)


    fun obterResumosTipo(): LiveData<List<ResumoTipo>>

    fun obteTipo(metodo: Metodo): LiveData<List<Tipo>>
}