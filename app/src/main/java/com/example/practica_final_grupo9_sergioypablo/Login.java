package com.example.practica_final_grupo9_sergioypablo;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


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
    }

    public void clickBoton (View view){
        txt = findViewById(R.id.editTextText);
        String nombre = txt.getText().toString();
        Intent intent = new Intent(this, ActividadPrincipal.class);
        intent.putExtra("nombre", nombre);
        stfrores.launch(intent);
    }
}