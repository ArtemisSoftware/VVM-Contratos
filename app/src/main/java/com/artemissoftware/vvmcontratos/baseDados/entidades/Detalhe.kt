package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "detalhes",
    indices = [Index(value = ["tipo"], unique = false)],
    foreignKeys = [ForeignKey(
        entity = Tipo::class,
        parentColumns = ["id", "tipo", "codigo", "idPai"],
        childColumns =  ["idTipo", "tipo", "codigo", "idPai"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Detalhe(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,


    @NonNull
    val idTipo: String,

    @NonNull
    val tipo: String,

    @NonNull
    val codigo: String,

    @NonNull
    val idPai: String,



    @NonNull
    val idDetalhe: Int,

    @NonNull
    val detalhe: String
) {
}