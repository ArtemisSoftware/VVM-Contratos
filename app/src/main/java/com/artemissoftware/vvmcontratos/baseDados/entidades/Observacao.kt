package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "observacoes",
    primaryKeys = ["idContrato", "numero"],
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Observacao(

    val idContrato: Int,
    val numero: String,

    @NonNull
    val texto: String


) {
}