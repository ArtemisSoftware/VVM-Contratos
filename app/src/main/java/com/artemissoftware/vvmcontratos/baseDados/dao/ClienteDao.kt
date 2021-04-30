package com.artemissoftware.vvmcontratos.baseDados.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.artemissoftware.vvmcontratos.baseDados.entidades.Cliente
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.ui.cliente.modelos.ClienteRegisto

@Dao
interface ClienteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(cliente: Cliente)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(cliente: List<Cliente>)


    @Query("SELECT * FROM clientes WHERE idContrato =:idContrato")
    fun obterCliente(idContrato: Int): LiveData<ClienteRegisto>
}