package com.artemissoftware.vvmcontratos.utils.extensoes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.artemissoftware.vvmcontratos.ui.acordo.adaptadores.AcordosAdaptador
import com.artemissoftware.vvmcontratos.ui.acordo.adaptadores.OnAcordoListener
import com.jaredrummler.materialspinner.MaterialSpinner


@BindingAdapter("acordos", "listener")
fun RecyclerView.setAcordosRealizados(items: List<Contrato>?, listener: OnAcordoListener) {

    if (items == null) {
        return
    }

    val layoutManager = this.layoutManager

    if (layoutManager == null) {
        this.layoutManager = LinearLayoutManager(this.context)
    }

    if(this.adapter == null){
        this.adapter = AcordosAdaptador(listener)
    }

    (this.adapter as AcordosAdaptador).submitList(items)

}
