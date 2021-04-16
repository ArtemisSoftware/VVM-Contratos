package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "servicos",
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Servico(

    val idContrato: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,


    val idProduto: Int,
    val idServico: Int,
    val idEmpresa: Int,
    val idMarca: Int,

    val unidades: Int,
    val valorUnitario: Double,
    val valorLiquido: Double,

    val idRegistoPai: Int,
    val idAnuidade: Int


    //TODO: faltam campos
) {
}