package com.example.practica_final_grupo9_sergioypablo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DnDTABLA (nombre_jugador TEXT, nombre_personaje TEXT, clase TEXT, fuerza INT, destreza INT, constitucion INT, inteligencia INT, sabiduria INT, carisma INT, habilidades TEXT, PRIMARY KEY (nombre_jugador, nombre_personaje))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
