package com.artemissoftware.vvmcontratos.utils.extensoes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artemissoftware.vvmcontratos.baseDados.entidades.Contrato
import com.jaredrummler.materialspinner.MaterialSpinner


@BindingAdapter("acordos"/*, "listener"*/)
fun RecyclerView.setAcordosRealizados(items: List<Contrato>?/*,listener: OnAnomaliasListener?*/) {

    if (items == null) {
        return
    }

    val layoutManager = this.layoutManager

    if (layoutManager == null) {
        this.layoutManager = LinearLayoutManager(this.context)
    }

    if(this.adapter == null){

    }

//    var adapter: AnomaliaRegistadaRecyclerAdapter? =
//        view.adapter as AnomaliaRegistadaRecyclerAdapter?
//    if (adapter == null) {
//        adapter = AnomaliaRegistadaRecyclerAdapter(view.context, items, listener)
//        view.adapter = adapter
//    } else {
//        adapter.atualizar(items)
//    }
}
