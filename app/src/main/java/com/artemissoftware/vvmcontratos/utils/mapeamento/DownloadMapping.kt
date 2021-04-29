package com.artemissoftware.vvmcontratos.utils.mapeamento

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.baseDados.entidades.*
import com.artemissoftware.vvmcontratos.utils.constantes.Identificadores

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


fun DadosClienteDto.map(idContrato: Int): MutableList<Cliente> {

    val clientes = mutableListOf<Cliente>()

    this.clientes.forEach {

        var idGrupoAtividade: Int
        var idAtividade1: String
        var idAtividade2: String? = null

        if (it.cae.equals("") == false) {

            idGrupoAtividade  = Identificadores.CAE
            idAtividade1 = it.cae

            if (it.actividadeCae2.equals("") == false) {
                idAtividade2 = it.cae2
            }

        }
        else{
            idGrupoAtividade  = Identificadores.CIRS
            idAtividade1 = it.cirs
        }


        clientes.add(
            Cliente(
                idContrato = idContrato,
                nome = it.nome,
                email = it.email,
                responsavel = it.responsavel,
                nib = it.nib,
                niss = it.niss,
                segmento = it.segmento,
                clean = it.clean,
                nif = it.nif,
                idGrupoAtividade = idGrupoAtividade,
                idAtividade1 = idAtividade1,
                idAtividade2 = idAtividade2,
                emailAutorizado = if (it.emailAutenticado == 1) true else false,
                extintores = if (it.extintores == 1) true else false
            )
        )
    }


    return clientes
}


fun MoradaDto.map(idContrato: Int): MutableList<Morada> {

    val moradas = mutableListOf<Morada>()

    this.enderecos.forEach {

        moradas.add(
            Morada(
                idContrato = idContrato,
                idMorada = it.idMorada.toString(),
                idTipoMorada = it.idTipoMorada,
                endereco = it.morada,
                idMarca = it.idMarca,

                freguesia = it.freguesia,
                localidade = it.localidade,
                cp4 = it.cp4,
                cp3 = it.cp3,
                cpalf = it.cpalf,

                email = it.email,
                telefone1 = it.telefone1,
                telefone2 = it.telefone2,
                fax1 = it.fax1,
                fax2 = it.fax2,
                responsavel = it.responsavel,
                wifi = true

            )
        )
    }


    return moradas
}


//fun Boolean.toInt() = if (this) 1 else