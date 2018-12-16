package com.siobcode.miscontactos.fragments;

import com.siobcode.miscontactos.adapter.ContactoAdaptador;
import com.siobcode.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewfragmentView {

    public void generarLinearLayoutVertical();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contacto);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

}
