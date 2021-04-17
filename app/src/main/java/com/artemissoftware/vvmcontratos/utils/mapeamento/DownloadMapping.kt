package com.artemissoftware.vvmcontratos.utils.mapeamento

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.Atualizacao
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo

fun ListagemDto<TipoDto>.map() = Atualizacao(
    descricao = metodo,
    seloTemporal = seloTemporal,
    idTipo = 1
)

fun ListagemDto<TipoDto>.map_() : MutableList<Tipo> {

    val tmp = this

    val rr = mutableListOf<Tipo>()
    tmp.dadosNovos.forEach {

        rr.add(
            Tipo(
            id = it.id.toInt(),
            tipo = this.metodo,
            descricao = it.descricao,
            codigo = it.codigo,
            idPai = it.idPai,
            ativo = it.activo.compareTo(false)
            )
        )
    }

    return rr
}


//fun Boolean.toInt() = if (this) 1 else