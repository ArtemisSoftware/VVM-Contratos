package com.artemissoftware.vvmcontratos.api

import com.artemissoftware.vvmcontratos.api.modelos.DadosClienteDto
import com.artemissoftware.vvmcontratos.api.modelos.MoradaDto
import com.artemissoftware.vvmcontratos.api.modelos.NumeroContratoDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ContratosApi {


    @GET("Obter_DadosCliente")
    suspend fun obterDadosCliente(@Path("nif") nif :String, @Path("MessageDigest") messageDigest : String): DadosClienteDto

    @GET("Obter_DadosMoradasCliente")
    suspend fun obterMoradasCliente(@Path("nif") nif :String, @Path("empresa") empresa : String, @Path("MessageDigest") messageDigest : String): MoradaDto

    @GET("Obter_NumeroContrato")
    suspend fun obterNumeroContrato(@Query("empresa") empresa :String, @Path("marca") marca : String, @Path("MessageDigest") messageDigest : String): NumeroContratoDto


    companion object{

        const val URL ="http://www.vivamais.com/tablet_contratosnovos_ws/service.asmx/"

    }
}