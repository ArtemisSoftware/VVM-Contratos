package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "participantes",
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Participante(

    val idContrato: Int,

    val idServico: Int,
    val idMorada: Int,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val nacionalidade: String,
    val profissao: String,
    val idCategoriaProfissional: Int,
    val posto: String,


    val dataNascimento: Date,
    val dataAdmissao: Date,

    val idGenero: Int,
    val idClinica: Int

//TODO: faltam campos
) {
}