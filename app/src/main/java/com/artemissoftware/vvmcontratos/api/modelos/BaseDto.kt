package com.artemissoftware.vvmcontratos.api.modelos

import com.google.gson.annotations.SerializedName

open class BaseDto (

    @SerializedName("metodo")
    val metodo: String
)

open class BaseListagemDto<T>(

    @SerializedName("TimeStamp")
    val seloTemporal: String,

    @SerializedName("metodo")
    val metodo: String,


    @SerializedName(value = "dadosNovos", alternate = ["Novos", "UtilizadoresNovos"])
    val dadosNovos: List<T>,

    @SerializedName(value = "dadosAlterados", alternate = ["Alterados", "UtilizadoresAlterados"])
    val dadosAlterados: List<T>

)