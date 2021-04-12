package com.artemissoftware.vvmcontratos.api.modelos.pedido


import com.google.gson.annotations.SerializedName

data class NumeroContratoDto(

    @SerializedName("NumeroContrato")
    val numeroContrato: Int
)