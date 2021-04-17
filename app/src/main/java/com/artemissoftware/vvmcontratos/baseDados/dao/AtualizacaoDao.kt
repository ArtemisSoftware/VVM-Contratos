package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.artemissoftware.vvmcontratos.baseDados.entidades.Atualizacao

@Dao
interface AtualizacaoDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(atualizacao: Atualizacao)
}