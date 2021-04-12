package com.artemissoftware.vvmcontratos.api.modelos


import com.google.gson.annotations.SerializedName

data class NumeroContratoDto(

    @SerializedName("NumeroContrato")
    val numeroContrato: Int
)