package com.artemissoftware.vvmcontratos.utils.metodos

import android.text.Html

class StringUtil {

    companion object {


        /**
         * Metodo que permite converter um inteiro para String
         * @param valor o valor a converter
         * @return o valor convertido
         */
        fun converterString(valor: Int): String {
            return valor.toString() + ""
        }

        /**
         * Metodo que permite converter um inteiro para String
         * @param valor o valor a converter
         * @return o valor convertido
         */
        fun converterString(valor: Double): String {
            return valor.toString() + ""
        }


        /**
         * Metodo que permite formatar uma string com caracters html
         * @param valor o valor a formatar
         * @return o valor formatado
         */
        fun formatarHtml(valor: String): String {
            return if (valor == null) {
                ""
            } else Html.fromHtml(valor).toString()
        }

    }
}