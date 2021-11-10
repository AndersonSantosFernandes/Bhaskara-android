package com.meu.minhatela02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Temperatura extends AppCompatActivity {

    private EditText entraValor1;
    private TextView saida;
    private Button calcular;
    private RadioButton cpf, fpc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        getSupportActionBar().hide();

        entraValor1 = findViewById(R.id.valorTemperatura);
        saida = findViewById(R.id.saida);
        calcular = findViewById(R.id.buttonTemp);
        cpf = findViewById(R.id.radioCPF);
        fpc = findViewById(R.id.radioFPC);

        Button btCalc = findViewById(R.id.buttonTemp);
        btCalc.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                String valor = entraValor1.getText().toString();

                if(valor.isEmpty()){
                    Snackbar.make(view,"Insira um valor para conversão",Snackbar.LENGTH_SHORT).show();
                }else{
                    double input = Double.parseDouble(String.valueOf(entraValor1.getText()));
                    double farenheit;
                    double celcius;

                    //(32 °F − 32) × 5/9 = 0 °C
                   // (0 °C × 9/5) + 32 = 32 °F
                  if (cpf.isChecked()){
                      farenheit = (input * 9/5) +32;
                      saida.setText(input+" graus celcius equivalem a\n "+farenheit+" farenheit");
                      entraValor1.setText("");
                  }else if (fpc.isChecked()){
                        celcius = (input - 32)* 5/9;
                        saida.setText(input+ "farenheit equivalem a "+celcius+" graus celcius");
                        entraValor1.setText("");
                    }else{
                      Snackbar.make(view,"Escolha um modo de conversão",Snackbar.LENGTH_SHORT).show();
                  }



                }

            }


        });

    }
}