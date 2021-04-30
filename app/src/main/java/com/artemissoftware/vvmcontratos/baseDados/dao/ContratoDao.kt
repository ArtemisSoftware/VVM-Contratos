package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo

@Dao
interface ContratoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(contrato: Contrato): Long


    @Query("SELECT * FROM contratos ORDER BY id ASC ")
    fun obterAcordosRealizados(): LiveData<List<Contrato>>
}