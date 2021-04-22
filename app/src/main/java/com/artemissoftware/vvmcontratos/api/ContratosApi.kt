package com.artemissoftware.vvmcontratos.api

import com.artemissoftware.vvmcontratos.api.modelos.ListagemDto
import com.artemissoftware.vvmcontratos.api.modelos.pedido.*
import com.artemissoftware.vvmcontratos.utils.Recurso
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

interface ContratosApi {


    companion object{

        const val URL ="http://www.vivamais.com/tablet_contratosnovos_ws/service.asmx/"

    }


    @GET("Obter_DadosCliente")
    suspend fun obterDadosCliente(@Query("nif") nif :String, @Query("MessageDigest") messageDigest : String): Response<DadosClienteDto>

    @GET("Obter_DadosMoradasCliente")
    suspend fun obterMoradasCliente(@Query("nif") nif :String, @Query("empresa") empresa : String, @Query("MessageDigest") messageDigest : String): Response<MoradaDto>

    @GET("Obter_NumeroContrato")
    suspend fun obterNumeroContrato(@Query("empresa") idEmpresa :String, @Query("marca") idMarca : String, @Query("MessageDigest") messageDigest : String): Response<NumeroContratoDto>





    @GET("{metodo}?dataT=")
    suspend fun obterTipo(@Path("metodo") metodo: String): Response<ListagemDto<TipoDto>>

    @GET("{metodo}")
    suspend fun obterTipo(@Path("metodo") metodo: String, @Query("dataT") seloTemporal: String): ListagemDto<TipoDto>



    @GET("Obter_Utilizador")
    suspend fun obterUtilizador(@Query("dataT") data: String = "", @Query("Id") id: String, @Query("Password") palavraChave: String, @Query("MessageDigest") messageDigest: String): ListagemDto<UtilizadorDto>




}