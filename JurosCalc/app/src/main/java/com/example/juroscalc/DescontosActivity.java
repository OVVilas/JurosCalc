package com.example.juroscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DescontosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descontos);

        Button btVolt = (Button) findViewById(R.id.btVoltDesc);
        btVolt.setOnClickListener(clickvolt);

        Button btCalc = (Button) findViewById(R.id.btCalcDesc);
        btCalc.setOnClickListener(clickcalc);
    }

    private View.OnClickListener clickvolt = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent situationIntent = new Intent(DescontosActivity.this, HomeActivity.class);
            startActivity(situationIntent);
            finish();
        }
    };

    private View.OnClickListener clickcalc = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText dnom = (EditText) findViewById(R.id.dNom);
            String txdnom = dnom.getText().toString();

            EditText dtax = (EditText) findViewById(R.id.dTax);
            String txdtax = dtax.getText().toString();

            EditText dtemp = (EditText) findViewById(R.id.dTemp);
            String txdtemp = dtemp.getText().toString();

            DecimalFormat df = new DecimalFormat("#.00");

            TextView dresultado = (TextView) findViewById(R.id.descResult);
            TextView dvalpres = (TextView) findViewById(R.id.descValPres);

            if (!txdnom.matches("") || !txdtax.matches("") || !txdtemp.matches("")) {
                Double valorDesconto = Double.parseDouble(txdnom) * (Double.parseDouble(txdtax)/100) * Double.parseDouble(txdtemp);
                dresultado.setText("Valor do desconto: R$ "+String.valueOf(df.format(valorDesconto)));
                Double valorPresente = Double.parseDouble(txdnom)-valorDesconto;
                dvalpres.setText("Valor presente: R$ "+String.valueOf(df.format(valorPresente)));
            } else{
                dresultado.setText("Preencha os campos.");
            }
        }
    };
}
