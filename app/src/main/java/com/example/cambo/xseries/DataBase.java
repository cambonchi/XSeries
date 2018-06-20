package com.example.cambo.xseries;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.BaseAdapter;

public class DataBase extends SQLiteOpenHelper {


    public DataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table  usuarios(id INTEGER primary key autoincrement,nombre txt,apellido txt,correo txt,fecha_nacimiento txt,saldo txt,contraseña txt,serie_comprada txt)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}



