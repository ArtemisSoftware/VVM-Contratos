package com.artemissoftware.vvmcontratos.utils.extensoes

import androidx.databinding.BindingAdapter
import com.artemissoftware.vvmcontratos.baseDados.entidades.Tipo
import com.jaredrummler.materialspinner.MaterialSpinner

@BindingAdapter("tipos")
fun MaterialSpinner.fixarTipos(tipos : List<Tipo>?) {

    tipos?.let {

        this.setItems(tipos)

//        item?.let{
//        for (index in tipos.indices) {
//            if (registos.get(index).id === registo.resultado.idAnomalia) {
//                view.setSelectedIndex(index)
//                break
//            }
//        }
//        }
    }

}