package com.artemissoftware.vvmcontratos.ui.cliente.modelos

import androidx.room.Embedded
import androidx.room.Relation
import com.artemissoftware.vvmcontratos.baseDados.entidades.Cliente
import com.artemissoftware.vvmcontratos.baseDados.entidades.Morada

class ClienteRegisto {

    @Embedded
    var cliente: Cliente? = null


    @Relation(parentColumn = "idMorada", entityColumn = "id")
    var morada: Morada? = null


}