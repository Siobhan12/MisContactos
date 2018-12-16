package com.siobcode.miscontactos.presentador;

import android.content.Context;

import com.siobcode.miscontactos.adapter.ContactoAdaptador;
import com.siobcode.miscontactos.db.ConstructorContactos;
import com.siobcode.miscontactos.fragments.IRecyclerViewfragmentView;
import com.siobcode.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecycleViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewfragmentView iRecyclerViewfragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecycleViewFragmentPresenter(IRecyclerViewfragmentView iRecyclerViewfragmentView, Context context) {
        this.iRecyclerViewfragmentView = iRecyclerViewfragmentView;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewfragmentView.inicializarAdaptadorRV(iRecyclerViewfragmentView.crearAdaptador(contactos));
        iRecyclerViewfragmentView.generarLinearLayoutVertical();
    }
}
