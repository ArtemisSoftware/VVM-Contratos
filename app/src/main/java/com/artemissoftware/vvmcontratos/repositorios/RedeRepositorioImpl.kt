package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.ContratosApi
import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.NumeroContratoDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.TipoDto
import com.artemissoftware.vvmcontratos.utils.Recurso
import com.himanshurawat.hasher.HashType
import com.himanshurawat.hasher.Hasher
import javax.inject.Inject

class RedeRepositorioImpl @Inject constructor(
    private val api: ContratosApi
):RepositorioBase(), RedeRepositorio{


    override suspend fun obterTipo(metodo: String): Recurso<ListagemDto<TipoDto>> {
        return getResult { api.obterTipo(metodo) }
    }

    override suspend fun obterDadosCliente(nif: String): Recurso<DadosClienteDto> {

        return getResult { api.obterDadosCliente(nif, Hasher.hash(nif,HashType.MD5)) }
    }

    override suspend fun obterMoradasCliente(nif: String, empresa: String): Recurso<MoradaDto> {

        val messageDigest = nif + empresa
        return getResult { api.obterMoradasCliente(nif, empresa, Hasher.hash(messageDigest, HashType.MD5)) }
    }

    override suspend fun obterNumeroContrato(idEmpresa: String, idMarca: String): Recurso<NumeroContratoDto> {

        val messageDigest = idEmpresa + idMarca
        return getResult { api.obterNumeroContrato(idEmpresa, idMarca, Hasher.hash(messageDigest,HashType.MD5)) }
    }
}