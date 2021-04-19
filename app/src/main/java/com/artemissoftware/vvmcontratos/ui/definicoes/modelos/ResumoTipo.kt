package com.artemissoftware.vvmcontratos.ui.definicoes.modelos

import androidx.room.ColumnInfo

data class ResumoTipo(

    @ColumnInfo(name = "descricao")
    var descricao: String,


    @ColumnInfo(name = "numeroRegistos")
    var numeroRegistos: Int = 0,

    @ColumnInfo(name = "seloTemporal")
    var seloTemporal: String


) {
}