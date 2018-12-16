package com.siobcode.miscontactos.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siobcode.miscontactos.adapter.ContactoAdaptador;
import com.siobcode.miscontactos.R;
import com.siobcode.miscontactos.pojo.Contacto;
import com.siobcode.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.siobcode.miscontactos.presentador.RecycleViewFragmentPresenter;

import java.util.ArrayList;

public class RecylerViewFragment extends Fragment implements IRecyclerViewfragmentView {
    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecycleViewFragmentPresenter(this, getContext());
        return v;
    }

 @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contacto) {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
