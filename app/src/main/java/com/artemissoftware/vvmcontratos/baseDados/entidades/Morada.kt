package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "moradas",
    foreignKeys = [ForeignKey(
        entity = Tipo::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Morada(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @NonNull
    val idContrato: Int,

    val idMorada: String,
    val idTipoMorada: Int,
    val idMarca: Int,
    val endereco: String,
    val nova: Boolean = false,

    val freguesia: String,
    val localidade: String,
    val cp4: String,
    val cp3: String,
    val cpalf: String,

    val email: String,
    val telefone1: String,
    val telefone2: String,
    val fax1: String,
    val fax2: String,

    val pontoReferencia: String,
    val nomeContacto: String,
    val responsavel: String,
    val idCargo: Int,
    val wifi: Int



) {


}