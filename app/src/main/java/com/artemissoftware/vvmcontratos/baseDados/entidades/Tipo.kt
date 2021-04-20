package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "tipos",
    indices = [Index(value = ["tipo"], unique = false)],
    primaryKeys = ["id", "tipo", "codigo", "idPai"],
    foreignKeys = [ForeignKey(
        entity = Atualizacao::class,
        parentColumns = ["descricao"],
        childColumns = ["tipo"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Tipo(

    @NonNull
    val id: Int,

    @NonNull
    val tipo: String,

    @NonNull
    val descricao: String,

    @NonNull
    val codigo: String,

    @NonNull
    val idPai: String,

    @NonNull
    val ativo: Int

) {

    override fun toString(): String {
        return if (descricao == null) {
            ""
        } else{
            descricao
        }
    }
}