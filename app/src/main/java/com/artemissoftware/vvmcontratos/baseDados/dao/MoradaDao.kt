package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.artemissoftware.vvmcontratos.baseDados.entidades.Morada

@Dao
interface MoradaDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(moradas: List<Morada>)
}