package com.example.practica_final_grupo9_sergioypablo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Estadisticas extends AppCompatActivity {

    private ImageView[] imgs;
    private Button[] butons;

    private int iter;
    private int[] est;
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
        this.iter = 0;



    }

    public void generar(View view){
        LinearLayout ln = findViewById(R.id.layimg);
        if(this.iter == 0){
            ln.setVisibility(View.VISIBLE);
        }
        this.est[iter] = dados(view, this.imgs);
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