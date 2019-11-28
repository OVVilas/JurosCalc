package com.example.juroscalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btJsimp = (Button) findViewById(R.id.btJSimples);
        btJsimp.setOnClickListener(clickjsimp);

        Button btJcomp = (Button) findViewById(R.id.btJComposto);
        btJcomp.setOnClickListener(clickjcomp);

        Button btDsimp = (Button) findViewById(R.id.btDSimples);
        btDsimp.setOnClickListener(clickdsimp);
    }

    private View.OnClickListener clickjsimp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent situationIntent = new Intent(HomeActivity.this, jSimplesActivity.class);
            startActivity(situationIntent);
            finish();
        }
    };

    private View.OnClickListener clickjcomp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent situationIntent = new Intent(HomeActivity.this, jCompostoActivity.class);
            startActivity(situationIntent);
            finish();
        }
    };

    private View.OnClickListener clickdsimp = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent situationIntent = new Intent(HomeActivity.this, DescontosActivity.class);
            startActivity(situationIntent);
            finish();
        }
    };
}
