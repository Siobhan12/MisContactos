package com.siobcode.miscontactos;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.siobcode.miscontactos.adapter.ContactoAdaptador;
import com.siobcode.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();

        inicilizarAdaptador();

        /* poner los nombres en el list view
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }
        */

        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();;
            }
        });
        */
    }

    private void setSupportActionBar(Toolbar miActionBar) {
    }

    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.lollipop, "Siobhan Perez", "5635533", "sp@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.mushroom, "Joseph Quan", "5465385", "jq@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.rayos, "Maria Ken", "54853358", "mk@gmail.com", 4));
        contactos.add(new Contacto(R.drawable.banana, "Jesus Gutierrez", "5468233", "jg@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.rayos2,"Shivani Perez", "585586", "sp@gmail.com", 10));

    }
    public ContactoAdaptador adaptador;
    public void inicilizarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
        listaContactos.setAdapter(adaptador);
    }
}

