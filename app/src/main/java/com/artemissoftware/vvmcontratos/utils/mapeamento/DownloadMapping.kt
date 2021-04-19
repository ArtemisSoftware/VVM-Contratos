package com.artemissoftware.vvmcontratos.utils.mapeamento

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.Atualizacao
import com.artemissoftware.vvmcontratos.baseDados.entidades.Detalhe
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
            ativo = if (it.activo == 1) 1 else 0
            )
        )
    }

    return rr
}



fun ListagemDto<TipoDto>.mapDetalhe() : MutableList<Detalhe> {

    val tmp = this

    val rr = mutableListOf<Detalhe>()
    tmp.dadosNovos.forEach {



        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe1, 1))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe2, 2))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe3, 3))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe4, 4))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe5, 5))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe6, 6))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe7, 7))
        rr.addAll(obterDetalhe(this.metodo, it, it.detalhe8, 8))

    }

    return rr
}


private fun obterDetalhe(metodo: String, tipo: TipoDto, detalhe: List<String>, idDetalhe: Int): List<Detalhe>{

    val rr = mutableListOf<Detalhe>()

    detalhe.forEach {

        rr.add(Detalhe(idTipo = tipo.id,
                        tipo = metodo,
                        codigo = tipo.codigo,
                        idPai = tipo.idPai,
                        idDetalhe = idDetalhe,
                        detalhe = it))
    }

    return rr
}

//fun Boolean.toInt() = if (this) 1 else