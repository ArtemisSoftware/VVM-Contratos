package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "atualizacoes"
)
data class Atualizacao(

    @PrimaryKey
    val descricao: String,


    @NonNull
    val idTipo: Int,


    @ColumnInfo(name = "seloTemporal")
    @NonNull
    val seloTemporal: String

) {
}