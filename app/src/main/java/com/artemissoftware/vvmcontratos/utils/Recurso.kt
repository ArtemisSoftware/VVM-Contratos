package com.artemissoftware.vvmcontratos.utils

sealed class Recurso<T>(val dados: T?, val messagem: String?) {

    class Sucesso<T>(dados: T): Recurso<T>(dados, messagem = null)
    class Erro<T>(messagem: String): Recurso<T>(dados = null, messagem = messagem)
}