package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.ui.definicoes.modelos.ResumoTipo
import kotlinx.coroutines.flow.Flow

@Dao
interface TipoDao {


    @Query("SELECT * FROM tipos WHERE tipo =:tipo  AND ativo = 1 ORDER BY id ASC ")
    fun obterTipo(tipo: String): Flow<List<Tipo>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(tipos: List<Tipo>)



    @Query("SELECT DISTINCT atl.descricao as descricao, numeroRegistos, seloTemporal FROM atualizacoes as atl LEFT JOIN (SELECT tipo, COUNT(id) as numeroRegistos FROM tipos WHERE ativo = 1 GROUP BY tipo) as tp ON atl.descricao = tp.tipo  WHERE numeroRegistos > 0 AND atl.descricao= tp.tipo ORDER BY descricao ASC")
    fun obterResumos():  LiveData<List<ResumoTipo>>

}