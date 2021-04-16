package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "extintores",
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Extintor(

    val idContrato: Int,

    val idServico: Int,
    val idMorada: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val numeroSerie: String,
    val idTipoExtintor: Int,

    val dataValidade: Date,
    val dataCarregamento: Date

//TODO: faltam campos
) {
}