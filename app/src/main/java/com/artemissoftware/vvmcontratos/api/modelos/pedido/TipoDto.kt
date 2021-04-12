package com.artemissoftware.vvmcontratos.api.modelos.pedido


import com.artemissoftware.vvmcontratos.api.modelos.BaseListagem
import com.google.gson.annotations.SerializedName

data class TipoDto(

    @SerializedName("Id")
    val id: String,

    @SerializedName("IdPai")
    val idPai: String,

    @SerializedName("Activo")
    val activo: Boolean,

    @SerializedName("Codigo")
    val codigo: String,

    @SerializedName("Descricao")
    val descricao: String,




    @SerializedName("Detalhe1")
    val detalhe1: List<String>,

    @SerializedName("Detalhe2")
    val detalhe2: List<String>,

    @SerializedName("Detalhe3")
    val detalhe3: List<String>,

    @SerializedName("Detalhe4")
    val detalhe4: List<String>,

    @SerializedName("Detalhe5")
    val detalhe5: List<String>,

    @SerializedName("Detalhe6")
    val detalhe6: List<String>,

    @SerializedName("Detalhe7")
    val detalhe7: List<String>,

    @SerializedName("Detalhe8")
    val detalhe8: List<String>

)

class TipoListagemDto : BaseListagem<TipoDto>()