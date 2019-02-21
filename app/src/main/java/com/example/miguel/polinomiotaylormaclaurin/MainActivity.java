package com.example.miguel.polinomiotaylormaclaurin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView aprox, ea, er, ep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aprox = (TextView) findViewById(R.id.aprox);
        ea = (TextView) findViewById(R.id.ea);
        er = (TextView) findViewById(R.id.er);
        ep = (TextView) findViewById(R.id.ep);
        labelSettings();
    }

    public void labelSettings(){
        aprox.setText("MacLaurin:");
        ea.setText("EA:");
        er.setText("ER:");
        ep.setText("ERP:");
    }

    public void calculos(View v){
        aprox.setText("dd");
    }
}
