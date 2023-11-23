package com.example.practica_final_grupo9_sergioypablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActividadPrincipal extends AppCompatActivity {

    AdminSQLiteOpenHelper gestor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        gestor = new AdminSQLiteOpenHelper(this, "PracticaFinalDB", null, 1);

    }
}