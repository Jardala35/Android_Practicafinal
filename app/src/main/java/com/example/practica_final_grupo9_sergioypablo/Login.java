package com.example.practica_final_grupo9_sergioypablo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;


public class Login extends AppCompatActivity {
    ActivityResultLauncher<Intent> stfrores = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            EditText txt2 = findViewById(R.id.editTextText);
            txt2.setText("");

        }
    });
    AdminSQLiteOpenHelper gestor;
    EditText txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.editTextText);
        gestor = new AdminSQLiteOpenHelper(this, "PracticaFinalDB", null, 1);
        // Esto es para resetear la base de datos
        //SQLiteDatabase db = gestor.getWritableDatabase();
        //db.deleteDatabase(new File(db.getPath()));
        //gestor.close();
    }

    public void clickBoton (View view){
        txt = findViewById(R.id.editTextText);
        String nombre = txt.getText().toString();
        if(!"".equals(nombre)){
            Intent intent = new Intent(this, ActividadPrincipal.class);
            intent.putExtra("nombre", nombre);
            stfrores.launch(intent);
        }else{
            Toast.makeText(this, "Se requiere un nombre para continuar", Toast.LENGTH_SHORT).show();
        }

    }
}