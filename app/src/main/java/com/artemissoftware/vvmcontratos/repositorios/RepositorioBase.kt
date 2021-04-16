package com.artemissoftware.vvmcontratos.repositorios

import com.artemissoftware.vvmcontratos.utils.Recurso
import retrofit2.Response

abstract class RepositorioBase {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Recurso<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Recurso.Sucesso(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Recurso<T> {

        return Recurso.Erro("Network call has failed for a following reason: $message")
    }
}