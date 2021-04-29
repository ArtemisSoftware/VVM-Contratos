package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "moradas",
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
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
    val cpalf: String? = null,

    val email: String,
    val telefone1: String,
    val telefone2: String? = null,
    val fax1: String? = null,
    val fax2: String? = null,

    val pontoReferencia: String? = null,
    val nomeContacto: String? = null,
    val responsavel: String,
    val idCargo: Int = 0,
    val wifi: Boolean



) {


}