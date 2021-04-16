package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "assinaturas",
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Assinatura(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val idContrato: Int,

    val idTipo: Int,
    val idOpcao: Int,

    val data: Date? = null,

    @ColumnInfo(name = "imagem", typeAffinity = ColumnInfo.BLOB)
    val imagem: ByteArray

) {
}