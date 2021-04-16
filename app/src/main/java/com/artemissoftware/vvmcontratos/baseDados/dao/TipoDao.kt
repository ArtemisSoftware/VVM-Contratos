package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.room.Dao
import androidx.room.Query
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import kotlinx.coroutines.flow.Flow

@Dao
interface TipoDao {


    @Query("SELECT * FROM tipos WHERE tipo =:tipo  AND ativo = 1 ORDER BY id ASC ")
    fun obterTipo(tipo: String): Flow<List<Tipo>>


}