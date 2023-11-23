package com.example.practica_final_grupo9_sergioypablo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class ActividadPrincipal extends AppCompatActivity {

    private AdminSQLiteOpenHelper gestor;
    private String[] opSpinner;
    private Spinner opcionesSpinner;
    private int[] fotosClases;
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