package com.artemissoftware.vvmcontratos.utils.metodos

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DatasUtil {

    companion object {

        const val FORMATO_DD_MM_YYYY = "dd-MM-yyyy"
        const val FORMATO_YYYY_MM_DD = "yyyy-MM-dd"
        const val DATA_FORMATO_YYYY_MM = "yyyy-MM"
        const val FORMATO_YYYY_MM_DD__HH_MM_SS = "yyyy-MM-dd HH:mm:ss"
        const val FORMATO_FICHEIRO_BD = "dd-MM-yyyy_HHmmss"

        const val FORMATO_DD_MM_YYYY__HH_MM = "dd-MM-yyyy HH:mm"
        const val FORMATO_DD_MM_YYYY__HH_MM_SS = "dd-MM-yyyy HH:mm:ss"
        const val DATA_FORMATO_DD_MM_YYYY__HH_MM_SS_V2 = "dd/MM/yyyy HH:mm:ss"

        const val FORMATO_DD_MMMM_YYYY = "dd-MMMM-yyyy"
        const val DATA_FORMATO_MMMM_YYYY = "MMMM yyyy"
        const val HORA_FORMATO_HH_MM = "HH:mm"
        const val HORA_FORMATO_HH_MM_SS = "HH:mm:ss"


        /**
         * Metodo que converte uma dados no formato string para o formato date
         * @param data dados a converter (YYYY-mm-dd)
         * @param formatoData o formato da dados (ex:dd/MM/yyyy)
         * @return uma dados
         */
        @JvmStatic
        fun converterData(data: String?, formatoData: String?): String {

            var data = data ?: return ""

            val formatter = SimpleDateFormat(FORMATO_YYYY_MM_DD__HH_MM_SS)

            var novaData: Date? = null
            try {
                novaData = formatter.parse(data)
                val df: DateFormat = SimpleDateFormat(formatoData)
                data = df.format(novaData)
            } catch (e: ParseException) {
                e.printStackTrace()
            }

            return data
        }
    }


}