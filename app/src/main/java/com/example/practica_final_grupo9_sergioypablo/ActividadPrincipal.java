package com.example.practica_final_grupo9_sergioypablo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActividadPrincipal extends AppCompatActivity {

    private AdminSQLiteOpenHelper gestor;
    private String[] opSpinner;
    private Spinner opcionesSpinner;
    private int[] fotosClases;
    private String habilidades = "";
    private String nombre = "";
    private EditText personaje;
    private int[] estadisticas;



    ActivityResultLauncher<Intent> stfrores = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                estadisticas = intent.getIntArrayExtra("estadisticas");
                Button btnest = findViewById(R.id.button2);
                btnest.setClickable(false);
                btnest.setBackgroundColor(Color.parseColor("#FF474444"));
            }
        }
    });
    ActivityResultLauncher<Intent> gana = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){
                Intent data = result.getData();
                if(data != null){
                    habilidades = data.getStringExtra("Habilidades");
                    Button btnhab = findViewById(R.id.button3);
                    btnhab.setClickable(false);
                    btnhab.setBackgroundColor(Color.parseColor("#FF474444"));
                }

            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        opSpinner = getResources().getStringArray(R.array.spinner2);
        fotosClases = new int[]{R.drawable.barbaro, R.drawable.bardo, R.drawable.clerigo, R.drawable.druida, R.drawable.guerrero, R.drawable.monje, R.drawable.paladin, R.drawable.explorado, R.drawable.picaro, R.drawable.hechicero, R.drawable.brujo, R.drawable.mago};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_principal);
        gestor = new AdminSQLiteOpenHelper(this, "PracticaFinalDB", null, 1);
        opcionesSpinner = findViewById(R.id.spinner);
        PaisesAdapter adaptador = new PaisesAdapter();
        opcionesSpinner.setAdapter(adaptador);
        Intent intent = getIntent();
        if (intent != null) {
             nombre = intent.getStringExtra("nombre");
        }
    }

    public void estadisticas(View view){
        Intent intent = new Intent(this, Estadisticas.class);
        stfrores.launch(intent);
    }

    public void habilidades(View view){
        Intent intent = new Intent(this, Habilidades.class);
        gana.launch(intent);
    }

    public void insertarCompleto(View view){
        personaje = findViewById(R.id.editTextPersonaje);
        if(estadisticas == null || "".equals(habilidades)){
            Toast.makeText(this, "Complete la seleccion de estadisticas y habilidades", Toast.LENGTH_SHORT).show();
        }else if(personaje.getText().toString().equals("")) {
            Toast.makeText(this, "Su personaje necesita un nombre", Toast.LENGTH_SHORT).show();
        }else{
            String spinnerSeleccionado = opcionesSpinner.getSelectedItem().toString();
            String perso = personaje.getText().toString();
            SQLiteDatabase db = gestor.getReadableDatabase();
            ContentValues valores = new ContentValues();
            valores.put("nombre_jugador", nombre);
            valores.put("nombre_personaje", perso);
            valores.put("clase", spinnerSeleccionado);
            valores.put("habilidades", habilidades);
            valores.put("fuerza", estadisticas[0]);
            valores.put("destreza", estadisticas[1]);
            valores.put("constitucion", estadisticas[2]);
            valores.put("inteligencia", estadisticas[3]);
            valores.put("sabiduria", estadisticas[4]);
            valores.put("carisma", estadisticas[5]);
            db.insert("DnDTABLA", null, valores);
            db.close();
            finish();

        }

    }

    class PaisesAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return opSpinner.length;
        }

        @Override
        public Object getItem(int position) {
            return opSpinner[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from((ActividadPrincipal.this));
            convertView = inflater.inflate(R.layout.itemspinner, null);
            ImageView iv1 = convertView.findViewById(R.id.imageView);
            TextView tv1 = convertView.findViewById(R.id.tvV);
            iv1.setImageResource(fotosClases[position]);
            tv1.setText(opSpinner[position]);
            return convertView;
        }
    }
}