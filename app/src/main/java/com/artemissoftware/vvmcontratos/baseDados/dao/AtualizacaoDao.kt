package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artemissoftware.vvmcontratos.baseDados.entidades.Atualizacao

@Dao
interface AtualizacaoDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(atualizacao: Atualizacao)


    @Query("DELETE FROM atualizacoes WHERE descricao =:descricao")
    suspend fun eliminar(descricao: String)
}