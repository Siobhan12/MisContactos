package com.siobcode.miscontactos.db;

import android.app.usage.ConfigurationStats;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.siobcode.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper  {
    private Context context;
    public BaseDatos(Context context){
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaContacto = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_NAME + "(" +
                                        ConstantesBaseDatos.TABLE_CONTACTS_ID       + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE   + "TEXT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO + "TEXT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_EMAIL    + "TEXT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_FOTO     + "INTEEGER" +
                                        ")";
        String queryCrearTableLikesContacto = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT + "(" +
                                              ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," +
                                              ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "INTEGER," +
                                              ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + "INTEGER," +
                                              "FOREIGN KEY ( " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                                              "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "("+ ConstantesBaseDatos.TABLE_CONTACTS_ID  + ") "+
                                              ")";

        db.execSQL(queryCrearTablaContacto);
        db.execSQL(queryCrearTableLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_CONTACTS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        onCreate(db);
    }

    ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()) {
            Contacto contactoActual = new Contacto();
            contactoActual.setId(registros.getInt(0));
            contactoActual.setNombre(registros.getString(1));
            contactoActual.setTelefono(registros.getString(2));
            contactoActual.setEmail(registros.getString(3));
            contactoActual.setFoto(registros.getInt(4));

            contactos.add(contactoActual);
        }
        db.close();
        return contactos;
    }
    void insertarContacto(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
                db.insert(ConstantesBaseDatos.TABLE_CONTACTS,null, contentValues);
        db.close();
    }

    void insertarLikeContacto(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto) {
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + "="+ contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
