package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "utilizadores"
)
class Utilizador(

    @PrimaryKey
    val id: String,

    @NonNull
    val nome: String,

    @NonNull
    val ativo: Int,


    val ocupacao: String,


    val contacto: String,


    val idTpa: String
)
{}