package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.NumeroContratoDto
import com.artemissoftware.vvmcontratos.baseDados.dao.ClienteDao
import com.artemissoftware.vvmcontratos.baseDados.dao.ContratoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.MoradaDao
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import javax.inject.Inject

class ContratoRepositorioImpl @Inject constructor(private val contratoDao: ContratoDao,
                                                  private val clienteDao: ClienteDao,
                                                  private val moradaDao: MoradaDao):ContratoRepositorio{


    override suspend fun inserirDadosContrato(idUtilizador: String, nif: String, tipoContrato: Tipo, empresa: Tipo, marca: Tipo,
                                              cliente: DadosClienteDto, moradas: MoradaDto, numeroContrato: NumeroContratoDto) {

        val contrato = Contrato(idUtilizador, nif, tipoContrato, empresa, marca, numeroContrato.numeroContrato)

        //val idContrato = contratoDao.inserir(contrato)

        //clienteDao.inserir()
        //moradaDao.inserir()
    }
}