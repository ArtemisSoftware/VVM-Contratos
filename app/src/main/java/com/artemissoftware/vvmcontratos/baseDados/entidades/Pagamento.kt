package com.artemissoftware.vvmcontratos.baseDados.entidades

import androidx.room.PrimaryKey
import java.util.*

data class Pagamento(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val idContrato: Int,


    val idProduto: Int,

    val data: Date,

    val valorPagarSemIva: Double,
    val valorPagarReferenteIva: Double,
    val valorContratoSemIva: Double,

    val producao: String,
    val numeroTrabalhadores: Int,
    val idTipoAtividade: Int,
    val referenciaCampanha: String,


    val idAnuidade: Int,
    val banco: String,
    val cheque: String,
    val nib: String

    //TODO: faltam campos
) {
}