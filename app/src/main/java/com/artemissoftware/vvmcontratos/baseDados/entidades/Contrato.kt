package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "contratos")
data class Contrato(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val uuid: String = UUID.randomUUID().toString().toUpperCase(),

    val idUtilizador: String,

    val nif: String,

    val idTipo: Int,
    val idEmpresa: Int,
    val idMarca: Int,
    val numero: String,

    val sincronizado: Boolean = false

    //val created: Long = System.currentTimeMillis()
    //TODO: faltam campos
) {

    @Ignore
    constructor(idUtilizador: String, nif: String, tipoContrato: Tipo, empresa: Tipo, marca: Tipo, numero: String):
            this(idUtilizador = idUtilizador, nif = nif, idTipo = tipoContrato.id, idEmpresa = empresa.id, idMarca = marca.id, numero= numero){

    }
//    val createdDateFormatted: String
//        get() = DateFormat.getDateTimeInstance().format(created)
}