package com.example.juroscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class jCompostoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_composto);

        Button btVolt = (Button) findViewById(R.id.btVoltComp);
        btVolt.setOnClickListener(clickvolt);

        Button btCalc = (Button) findViewById(R.id.btCalcComp);
        btCalc.setOnClickListener(clickcalc);
    }

    private View.OnClickListener clickvolt = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent situationIntent = new Intent(jCompostoActivity.this, HomeActivity.class);
            startActivity(situationIntent);
            finish();
        }
    };

    private View.OnClickListener clickcalc = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText ccap = (EditText) findViewById(R.id.cCap);
            String txccap = ccap.getText().toString();

            EditText ctax = (EditText) findViewById(R.id.cTax);
            String txctax = ctax.getText().toString();

            EditText ctemp = (EditText) findViewById(R.id.cTemp);
            String txctemp = ctemp.getText().toString();

            DecimalFormat df = new DecimalFormat("#.00");

            TextView tabcomp = (TextView) findViewById(R.id.tabComposto);
            tabcomp.setText("");

            if (!txccap.matches("") || !txctax.matches("") || !txctemp.matches("")) {
                for (int i = 0; i <= Integer.parseInt(txctemp); i++) {
                    Double montantec = Double.parseDouble(txccap) * Math.pow((1+ Double.parseDouble(txctax)/100), i);
                    Double montantec2 = Double.parseDouble(txccap) * Math.pow((1+ Double.parseDouble(txctax)/100), i-1);
                    if (i==0){
                        tabcomp.append("      "+i+"                  R$ "+df.format(montantec)+"                    R$ 0,00"+"\n");
                    } else{
                        tabcomp.append("      "+i+"                  R$ "+df.format(montantec)+"                    R$ "+df.format(montantec-montantec2)+"\n");
                    }
                }
            }else{
                tabcomp.setText("Preencha os campos.");
            }
        }

    };
}
