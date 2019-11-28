package com.example.juroscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class jSimplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_simples);

        Button btVolt = (Button) findViewById(R.id.btVolt);
        btVolt.setOnClickListener(clickvolt);

        Button btCalc = (Button) findViewById(R.id.btCalc);
        btCalc.setOnClickListener(clickcalc);


    }

    private View.OnClickListener clickvolt = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent situationIntent = new Intent(jSimplesActivity.this, HomeActivity.class);
            startActivity(situationIntent);
            finish();
        }
    };

    private View.OnClickListener clickcalc = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText cap = (EditText) findViewById(R.id.nCap);
            String txcap = cap.getText().toString();

            EditText tax = (EditText) findViewById(R.id.nTax);
            String txtax = tax.getText().toString();

            EditText temp = (EditText) findViewById(R.id.nTemp);
            String txtemp = temp.getText().toString();

            DecimalFormat df = new DecimalFormat("#.00");

            TextView resultado = (TextView) findViewById(R.id.jSimpRes);
            TextView jmes = (TextView) findViewById(R.id.jSimpMes);

            if (!txcap.matches("") || !txtax.matches("") || !txtemp.matches("")) {
                Double juroSimples = Double.parseDouble(txcap) * (Double.parseDouble(txtax)/100) * Double.parseDouble(txtemp);
                resultado.setText("Juros total: R$ "+String.valueOf(df.format(juroSimples)));
                Double jurosMes = juroSimples/Double.parseDouble(txtemp);
                jmes.setText("Juros ao mês: R$ "+String.valueOf(df.format(jurosMes)));
            } else{
                resultado.setText("Preencha os campos.");
            }
        }
    };
}
