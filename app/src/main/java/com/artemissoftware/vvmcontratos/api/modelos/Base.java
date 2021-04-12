package com.artemissoftware.vvmcontratos.api.modelos;

import com.google.gson.annotations.SerializedName;

public class Base {

    @SerializedName("metodo")
    public String metodo;

    @SerializedName("api")
    public int api;

    @SerializedName("codigo")
    public int codigo;
}
