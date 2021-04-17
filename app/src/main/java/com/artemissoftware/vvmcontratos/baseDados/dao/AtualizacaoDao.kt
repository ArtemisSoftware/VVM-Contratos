package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.artemissoftware.vvmcontratos.baseDados.entidades.Atualizacao
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo

@Dao
interface AtualizacaoDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(atualizacao: Atualizacao)
}