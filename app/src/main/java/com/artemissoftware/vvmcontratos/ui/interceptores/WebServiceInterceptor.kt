package com.artemissoftware.vvmcontratos.ui.interceptores

import com.google.gson.GsonBuilder
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONException
import org.json.JSONObject

class WebServiceInterceptor: Interceptor {

    private val gson = GsonBuilder().create()


    //TODO: completar dados

    override fun intercept(chain: Interceptor.Chain): Response {

        val pedido = chain.request()

        //


        val resposta = chain.proceed(pedido)
        val corpo = resposta.body
        val contentType = corpo!!.contentType()

        val body: ResponseBody = formatarResposta(corpo.string(), "metodo", pedido.headers).toResponseBody(contentType)
        return resposta.newBuilder().body(body).build()
    }


    private fun formatarResposta(respostaWS: String, metodo: String, cabecalho: Headers): String {

        var conteudo = obterJson(respostaWS)
        //val codigo: Int = validarConteudo(conteudo)

        return try {
            val resposta = JSONObject(conteudo)
            resposta.put("metodo", metodo)
            resposta.toString()
        } catch (e: JSONException) {
           ""
//            throw RespostaWsInvalidaException(
//                gson.toJson(
//                    Codigo(ID_500, e.message),
//                    Codigo::class.java
//                )
//            )
        }
    }


    private fun obterJson(respostaWS: String): String? {
        val dados: String = ""
        try {
            var inicio = respostaWS.indexOf(">[")
            var fim = 0
            if (inicio == -1) {
                inicio = respostaWS.indexOf('{')
                fim = respostaWS.indexOf("</string>")
            } else {
                inicio += 2
                fim = respostaWS.indexOf("]</string>")
            }
            val conteudo = respostaWS.substring(inicio, fim)
            //validarConteudo(conteudo)
            return conteudo
        } catch (e: NullPointerException) {
            //descodificarErro(respostaWS, e.message)
        } catch (e: StringIndexOutOfBoundsException) {
            //descodificarErro(respostaWS, e.message)
        }
        return dados
    }


//
//    @Throws(IOException::class)
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val pedido = chain.request()
//        if (pedido.header(Sintaxe.API.API) == null) {
//            throw MetodoWsInvalidoException(gson.toJson(Codigo_601, Codigo::class.java))
//        }
//        val metodo: String = TiposUtil.obterMetodo(
//            Int.pathSegments,
//            pedido.header(Sintaxe.API.METODO_INTERNO)
//        )
//        val api = pedido.header(Sintaxe.API.API)!!.toInt()
//        val resposta = chain.proceed(pedido)
//        val corpo = resposta.body
//        val contentType = corpo!!.contentType()
//        val body: ResponseBody = ResponseBody.create(
//            formatarResposta(corpo.string(), metodo, pedido.headers, api),
//            contentType
//        )
//        return resposta.newBuilder().body(body).build()
//    }

}