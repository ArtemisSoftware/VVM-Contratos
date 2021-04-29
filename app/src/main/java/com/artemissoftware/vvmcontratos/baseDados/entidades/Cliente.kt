package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "clientes",
    foreignKeys = [ForeignKey(
        entity = Contrato::class,
        parentColumns = ["id"],
        childColumns =  ["idContrato"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Cliente (

    @PrimaryKey
    val idContrato: Int,

    val idMorada: String? = null,
    val nome: String,

    val email: String,
    val emailAutorizado: Boolean = false,


    val idGrupoAtividade: Int,
    val idAtividade1: String,
    val idAtividade2: String? = null,


    val extintores: Boolean = false,
    val responsavel: String,
    val nif: String,

    val novo: Boolean = false,

    val nib: String,
    val niss: String,
    val segmento: String,
    val clean: String
)
{}