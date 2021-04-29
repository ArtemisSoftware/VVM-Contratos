package com.artemissoftware.vvmcontratos.api.modelos.pedido


import com.google.gson.annotations.SerializedName

data class DadosClienteDto(

    @SerializedName("Dados")
    val clientes: List<ClienteDto>,

    @SerializedName("TimeStamp")
    val timeStamp: String
)

data class ClienteDto(

    @SerializedName("Actividade")
    val actividadeCae: String,

    @SerializedName("Actividade2")
    val actividadeCae2: String,

    @SerializedName("CAE")
    val cae: String,

    @SerializedName("CAE2")
    val cae2: String,

    @SerializedName("CIRS")
    val cirs: String,

    @SerializedName("CLEAN")
    val clean: String,

    @SerializedName("descricaoCIRS")
    val descricaoCirs: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("emailAut")
    val emailAutenticado: Int,

    @SerializedName("Extintores")
    val extintores: Int,

    @SerializedName("Marca")
    val marca: String,

    @SerializedName("NIB")
    val nib: String,

    @SerializedName("NIF")
    val nif: String,

    @SerializedName("NISS")
    val niss: String,

    @SerializedName("Nome")
    val nome: String,

    @SerializedName("Responsavel")
    val responsavel: String,

    @SerializedName("Segmento")
    val segmento: String,

    @SerializedName("valorEmDivida")
    val valorEmDivida: String
)