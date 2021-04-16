package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "contratos")
data class Contrato(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val uuid: String = UUID.randomUUID().toString().toUpperCase(),

    val idUtilizador: String,

    val nif: String,

    val idTipo: String,
    val idEmpresa: String,
    val idMarca: String,
    val numero: String,

    val sincronizado: Boolean = false

    //val created: Long = System.currentTimeMillis()
    //TODO: faltam campos
) {

//    val createdDateFormatted: String
//        get() = DateFormat.getDateTimeInstance().format(created)
}