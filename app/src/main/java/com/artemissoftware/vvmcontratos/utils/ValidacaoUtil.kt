package com.artemissoftware.vvmcontratos.utils

object ValidacaoUtil {


    /**
     * Metodo que valida um nif
     * @param nif nif a ser validado
     * @return true caso o nif seja válido e false caso contrário
     */
    fun validarNif(nif: String): Boolean {

        val nifTeste = nif.toCharArray()

        if (nifTeste.size != 9) return false

        if ('1' == nifTeste[0] || '2' == nifTeste[0] || '3' == nifTeste[0]
            ||
            '5' == nifTeste[0] || '6' == nifTeste[0] || '7' == nifTeste[0]
            ||
            '8' == nifTeste[0] || '9' == nifTeste[0]) {

            var total = 0

            for (i in 0..7) {
                total += (nifTeste[i].toString() + "").toInt() * (9 - i)
            }

            var check = 11 - total % 11

            if (check >= 10) {
                check = 0
            }

            if (check == (nifTeste[8].toString() + "").toInt()) {
                return true
            }
        }
        return false
    }


}