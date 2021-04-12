package com.artemissoftware.vvmcontratos.api.modelos


import com.google.gson.annotations.SerializedName

data class MoradaDto(

    @SerializedName("Dados")
    val enderecos: List<EnderecoDto>,

    @SerializedName("TimeStamp")
    val timeStamp: String
)


data class EnderecoDto(

    @SerializedName("CP3")
    val cp3: String,

    @SerializedName("CP4")
    val cp4: String,

    @SerializedName("CPALF")
    val cpalf: String,

    @SerializedName("Email")
    val email: String,

    @SerializedName("Fax1")
    val fax1: String,

    @SerializedName("Fax2")
    val fax2: String,

    @SerializedName("Freguesia")
    val freguesia: String,

    @SerializedName("Id")
    val idMorada: String,

    @SerializedName("IdTipoMorada")
    val idTipoMorada: String,

    @SerializedName("Localidade")
    val localidade: String,

    @SerializedName("Marca")
    val marca: String,

    @SerializedName("Morada")
    val morada: Int,

    @SerializedName("Responsavel")
    val responsavel: String,

    @SerializedName("Telefone1")
    val telefone1: String,

    @SerializedName("Telefone2")
    val telefone2: String
)