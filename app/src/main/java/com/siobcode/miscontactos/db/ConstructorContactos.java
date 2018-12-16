package com.siobcode.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.siobcode.miscontactos.R;
import com.siobcode.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private static final int Like = 1;
    private Context context;
    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
       ArrayList <Contacto>contactos = new ArrayList<>();

        contactos.add(new Contacto(R.drawable.lollipop, "Siobhan Perez", "5635533", "sp@gmail.com", 5));
        contactos.add(new Contacto(R.drawable.mushroom, "Joseph Quan", "5465385", "jq@gmail.com", 8));
        contactos.add(new Contacto(R.drawable.rayos, "Maria Ken", "54853358", "mk@gmail.com", 10));
        contactos.add(new Contacto(R.drawable.banana, "Jesus Gutierrez", "5468233", "jg@gmail.com", 3));
        contactos.add(new Contacto(R.drawable.rayos2, "Shivani Perez", "585586", "sp@gmail.com", 4));
        return contactos;

       /*BaseDatos db = new BaseDatos(context);
       insertarTresContactos(db);
       return db.obtenerTodosLosContactos();*/
    }

    public void insertarTresContactos(BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Siobhan Perez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "787665478");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "sp@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.lollipop);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Joseph Quan");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "46538598");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "jq@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.mushroom);

        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, "Shivani Perez");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, "7585586");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, "ssp@gmail.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, R.drawable.rayos2);

        db.insertarContacto(contentValues);
    }
    
    public void darLikeContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, Like);

        db.insertarLikeContacto(contentValues);
    }

}
