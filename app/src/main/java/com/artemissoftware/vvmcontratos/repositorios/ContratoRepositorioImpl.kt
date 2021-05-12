package com.artemissoftware.vvmcontratos.repositorios

import androidx.lifecycle.LiveData
import com.artemissoftware.vvmcontratos.api.modelos.pedido.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.NumeroContratoDto
import com.artemissoftware.vvmcontratos.baseDados.dao.ClienteDao
import com.artemissoftware.vvmcontratos.baseDados.dao.ContratoDao
import com.artemissoftware.vvmcontratos.baseDados.dao.MoradaDao
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.artemissoftware.vvmcontratos.ui.cliente.modelos.ClienteRegisto
import com.artemissoftware.vvmcontratos.utils.mapeamento.map
import javax.inject.Inject

class ContratoRepositorioImpl @Inject constructor(private val contratoDao: ContratoDao,
                                                  private val clienteDao: ClienteDao,
                                                  private val moradaDao: MoradaDao):ContratoRepositorio{


    override suspend fun inserirDadosContrato(idUtilizador: String, nif: String, tipoContrato: Tipo, empresa: Tipo, marca: Tipo,
                                              cliente: DadosClienteDto, moradas: MoradaDto, numeroContrato: NumeroContratoDto) {

        val contrato = Contrato(idUtilizador, nif, tipoContrato, empresa, marca, numeroContrato.numeroContrato)

        val idContrato = contratoDao.inserir(contrato)

        val clientes = cliente.map(idContrato = idContrato.toInt())
        clienteDao.inserir(clientes)


        val enderecos = moradas.map(idContrato = idContrato.toInt())
        moradaDao.inserir(enderecos)
    }


    override fun obterAcordosRealizados(): LiveData<List<Contrato>> {
        return contratoDao.obterAcordosRealizados()
    }


    override fun obterCliente(idContrato: Int): LiveData<ClienteRegisto> {
        return clienteDao.obterCliente(idContrato)
    }


}