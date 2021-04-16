package com.artemissoftware.vvmcontratos.api.modelos.pedido

import com.google.gson.annotations.SerializedName

data class UtilizadorDto(

    @SerializedName("Id")
    val id: String,

    @SerializedName("Nome")
    val nome: String,

    @SerializedName("PalavraChave")
    val palavraChave: String,

    @SerializedName("Activo")
    val ativo: Int,

    @SerializedName("Ocupacao")
    val ocupacao: String,

    @SerializedName("Contacto")
    val contacto: String,

    @SerializedName("idTPA")
    val idTpa: String

) {


}