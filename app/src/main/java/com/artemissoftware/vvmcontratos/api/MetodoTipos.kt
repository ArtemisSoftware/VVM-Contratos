package com.artemissoftware.vvmcontratos.api

class MetodoTipos {

    companion object tipo{

        val EMPRESAS_VIVAMAIS = Metodo("Empresas_VivaMais","Obter_EmpresasVivaMais")
        val MARCAS = Metodo("Marcas","Obter_Marcas")
        val TIPOS_CONTRATOS = Metodo("Tipos_Contrato","Obter_TiposContrato")


        val LISTAGEM = listOf<Metodo>(EMPRESAS_VIVAMAIS, MARCAS, TIPOS_CONTRATOS)
    }
}

class Metodo(val descricao: String, val metodoApi: String)