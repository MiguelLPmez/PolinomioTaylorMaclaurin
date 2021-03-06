package com.example.miguel.polinomiotaylormaclaurin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView aprox, ea, er, ep;
    Button btnCalculate;
    RadioGroup rGroup;
    RadioButton rSin, rCos, rExponential;
    Polinomio p;
    EditText terms, point;
    int typef;

    public MainActivity(){
        p = new Polinomio();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        terms = findViewById(R.id.terms);
        point = findViewById(R.id.point);

        rSin = findViewById(R.id.rSin);
        rCos = findViewById(R.id.rCos);
        rExponential = findViewById(R.id.rExponential);

        aprox = findViewById(R.id.aprox);
        ea = findViewById(R.id.ea);
        er = findViewById(R.id.er);
        ep = findViewById(R.id.ep);

        labelSettings();

        btnCalculate = findViewById(R.id.btnCalculate);

        rGroup = findViewById(R.id.rGroup);

        btnCalculate.setEnabled(false);
    }

    public void dataVerification(){
        if(terms.getText().toString().length() == 0 || point.getText().toString().length() == 0) {
            btnCalculate.setEnabled(false);
            rGroup.clearCheck();
        } else
            btnCalculate.setEnabled(true);
    }

    public void labelSettings(){
        aprox.setText("MacLaurin:");
        ea.setText("EA:");
        er.setText("ER:");
        ep.setText("ERP:");
    }

    private Polinomio.Funcion getFunction(){
        if (rGroup.getCheckedRadioButtonId() == rSin.getId()) {
            typef = 0;
            return Polinomio.Funcion.SENO;
        }
        if (rGroup.getCheckedRadioButtonId() == rCos.getId()) {
            typef = 1;
            return Polinomio.Funcion.COSENO;
        }
        if (rGroup.getCheckedRadioButtonId() == rExponential.getId()) {
            typef = 2;
            return Polinomio.Funcion.EULER;
        }
        return null;
    }

    public void calculatePerformed(View v){
        if (terms.getText().toString().length() > 0 && point.getText().toString().length() > 0){
            double x = Double.parseDouble(String.valueOf(point.getText()));
            int n = Integer.parseInt(String.valueOf(terms.getText()));
            double a = p.polinomios(getFunction(), x, n);
            aprox.setText("MacLaurin: " + a);

            double eAbsoluto = Errores.absoluto(typef, x, a);
            ea.setText("EA:    " + eAbsoluto);

            double eRelativo = Errores.relativo(typef, x, a);
            er.setText("ER:    " + eRelativo);

            double ePorcentual = Errores.porcentual(typef, x, a);
            ep.setText("ERP:  " + ePorcentual);
        }else {
            btnCalculate.setEnabled(false);
            rGroup.clearCheck();
        }
    }

    public void rGroupPerformed(View v){
        dataVerification();
    }


}
