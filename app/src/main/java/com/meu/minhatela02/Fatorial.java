package com.meu.minhatela02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Fatorial extends AppCompatActivity {


    private EditText entraValor;
    private TextView resultado;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatorial);
        getSupportActionBar().hide();

        entraValor = findViewById(R.id.entrada);
        resultado = findViewById(R.id.mostrar);
        calcular = findViewById(R.id.buttonFat);

        Button btCalc = findViewById(R.id.buttonFat);
        btCalc.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                String valor = entraValor.getText().toString();

                if (valor.isEmpty()){
                    Snackbar.make(view,"Insira um valor entre 1 e 10",Snackbar.LENGTH_SHORT).show();
                }else{
                    int entrada = Integer.parseInt(String.valueOf(entraValor.getText()));
                    int cont = Integer.parseInt(String.valueOf(1));
                    if(entrada < 1 || entrada >10){
                        Snackbar.make(view,"Insira um valor entre 1 e 10",Snackbar.LENGTH_SHORT).show();
                    }else{


                        for(int i = 1; i<= entrada; i++) {
                            cont = cont *i;
                        }

                        resultado.setText("Fatorial de "+entrada+":\n"+cont);
                        entraValor.setText("");
                    }
                }
            }
        });

    }
}