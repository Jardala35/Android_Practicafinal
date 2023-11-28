package com.example.practica_final_grupo9_sergioypablo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Estadisticas extends AppCompatActivity {

    private ImageView[] imgs;
    private Button[] butons;
    private int iter;
    private int[] est;

    private EditText[] listaetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        est = new int[6];
        imgs = new ImageView[3];
        imgs[0] = findViewById(R.id.img1);
        imgs[1] = findViewById(R.id.img2);
        imgs[2] = findViewById(R.id.img3);
        butons = new Button[6];
        butons[0] = findViewById(R.id.btn1);
        butons[1] = findViewById(R.id.btn2);
        butons[2] = findViewById(R.id.btn3);
        butons[3] = findViewById(R.id.btn4);
        butons[4] = findViewById(R.id.btn5);
        butons[5] = findViewById(R.id.btn6);
        listaetxt = new EditText[6];
        listaetxt[0] = findViewById(R.id.etxt1);
        listaetxt[1] = findViewById(R.id.etxt2);
        listaetxt[2] = findViewById(R.id.etxt3);
        listaetxt[3] = findViewById(R.id.etxt4);
        listaetxt[4] = findViewById(R.id.etxt5);
        listaetxt[5] = findViewById(R.id.etxt6);

        this.iter = 0;



    }

    public void generar(View view){
        LinearLayout ln = findViewById(R.id.layimg);

        if(this.iter == 0){
            ln.setVisibility(View.VISIBLE);
        }


        if(view.getId() == R.id.btn1){
            this.est[0] = dados(view, this.imgs);
            this.listaetxt[0].setText(Integer.toString(this.est[0]));
        }
        if(view.getId() == R.id.btn2){
            this.est[1] = dados(view, this.imgs);
            this.listaetxt[1].setText(Integer.toString(this.est[1]));
        }
        if(view.getId() == R.id.btn3){
            this.est[2] = dados(view, this.imgs);
            this.listaetxt[2].setText(Integer.toString(this.est[2]));
        }
        if(view.getId() == R.id.btn4){
            this.est[3] = dados(view, this.imgs);
            this.listaetxt[3].setText(Integer.toString(this.est[3]));
        }
        if(view.getId() == R.id.btn5){
            this.est[4] = dados(view, this.imgs);
            this.listaetxt[4].setText(Integer.toString(this.est[4]));
        }
        if(view.getId() == R.id.btn6){
            this.est[5] = dados(view, this.imgs);
            this.listaetxt[5].setText(Integer.toString(this.est[5]));
        }
        iter++;
        view.setVisibility(View.INVISIBLE);

        if (iter == 5) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent();
                    intent.putExtra("estadisticas", est);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }, 2000);
        }

    }

    private int dados(View view, ImageView[] imgs){

        int aux = 0;
        for (int i = 0; i<3; i++){
            int rand = (int) (Math.random() * 6) + 1;
            switch (rand){
                case 1 : imgs[i].setImageResource(R.drawable.dado1);aux+= 1;break;
                case 2 : imgs[i].setImageResource(R.drawable.dado2);aux+= 2;break;
                case 3 : imgs[i].setImageResource(R.drawable.dado3);aux+= 3;break;
                case 4 : imgs[i].setImageResource(R.drawable.dado4);aux+= 4;break;
                case 5 : imgs[i].setImageResource(R.drawable.dado5);aux+= 5;break;
                case 6 : imgs[i].setImageResource(R.drawable.dado6);aux+= 6;break;

            }

        }
        return aux;
    }
}