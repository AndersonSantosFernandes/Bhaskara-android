package com.meu.minhatela02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class TelaDois extends AppCompatActivity {
    private EditText valorA, valorB, valorC;
    private TextView delta, x1linha, x2linha;
    private Button calculo, fatorial, temperatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_dois);
        getSupportActionBar().hide();
        IniciarComponentes();
        IniciarComponentes1();
        valorA = findViewById(R.id.editA);
        valorB = findViewById(R.id.editB);
        valorC = findViewById(R.id.editC);
        delta = findViewById(R.id.raizDelta);
        x1linha = findViewById(R.id.x1linha);
        x2linha = findViewById(R.id.x2linha);
        calculo = findViewById(R.id.buttonCalc);


        Button buttonCalc = findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String A = valorA.getText().toString();
                String B = valorB.getText().toString();
                String C = valorC.getText().toString();
                if(A.isEmpty() || B.isEmpty() || C.isEmpty()){
                    Snackbar.make(view,"A, B e C devem estar preenchidos",Snackbar.LENGTH_SHORT).show();
                }else{
                    double vlA = Double.parseDouble(String.valueOf(valorA.getText()));
                    double vlB = Double.parseDouble(String.valueOf(valorB.getText()));
                    double vlC = Double.parseDouble(String.valueOf(valorC.getText()));

                    double dlta = Math.pow(vlB,2)-(4*vlA*vlC);
                    double resultado = Math.sqrt(dlta) ;
                    double linha1 = (-vlB + resultado) / 2*vlA;
                    double linha2 = (-vlB - resultado) / 2*vlA;
                    delta.setText("Delta: "+ dlta+ " - Raiz de Delta: "+resultado);
                    x1linha.setText("X'  "+linha1);
                    x2linha.setText("X'' "+linha2);
                    valorA.setText("");
                    valorB.setText("");
                    valorC.setText("");
                }

            }
        });

        fatorial.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(TelaDois.this,Fatorial.class);
                startActivity(intent);
            }
        });

        temperatura.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(TelaDois.this,Temperatura.class);
                startActivity(intent);
            }
        });


    }

    private void IniciarComponentes1() {
        temperatura = findViewById(R.id.buttonFt);
    }

    private void IniciarComponentes(){
        fatorial = findViewById(R.id.Fatorial);
    }

    }
