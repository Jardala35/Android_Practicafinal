package com.example.practica_final_grupo9_sergioypablo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class Habilidades extends AppCompatActivity {

	private CheckBox[] cajitas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_habilidades);
		cajitas[0] = findViewById(R.id.checkAtletismo);
		cajitas[1] = findViewById(R.id.checkAcrobacias);
		cajitas[2] = findViewById(R.id.checkJManos);
		cajitas[3] = findViewById(R.id.checkSigilo);
		cajitas[4] = findViewById(R.id.checkArcano);
		cajitas[5] = findViewById(R.id.checkHistoria);
		cajitas[6] = findViewById(R.id.checkInvestigacion);
		cajitas[7] = findViewById(R.id.checkNaturaleza);
		cajitas[8] = findViewById(R.id.checkReligion);
		cajitas[9] = findViewById(R.id.checkMedicina);
		cajitas[10] = findViewById(R.id.checkPercepcion);
		cajitas[11] = findViewById(R.id.checkPerspicacia);
		cajitas[12] = findViewById(R.id.checkSupervivencia);
		cajitas[13] = findViewById(R.id.checkTratoAnimales);
		cajitas[14] = findViewById(R.id.checkEngaño);
		cajitas[15] = findViewById(R.id.checkIntimidacion);
		cajitas[16] = findViewById(R.id.checkInterpretacion);
		cajitas[17] = findViewById(R.id.checkPersuasion);
	}

	public void habilidadesTotales(View view){
		int aux = 0;
		String habilidades = "";
		habilidades = ((CheckBox) view).getText().toString();aux++;
		if (aux == 3){
			Intent intent = new Intent();
			intent.putExtra("Habilidades", habilidades);
			setResult(RESULT_OK, intent);
			finish();
		}
	}
}