package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText Valor1 = (EditText) findViewById(R.id.editTextText);
        EditText Valor2 = (EditText) findViewById(R.id.editTextText2);
        TextView Resultado = (TextView) findViewById(R.id.textView);

        Button Soma = (Button) findViewById(R.id.button3);
        Soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valor1 = Float.parseFloat(Valor1.getText().toString());
                float valor2 = Float.parseFloat(Valor2.getText().toString());
                float resultado = valor1 + valor2;
                Resultado.setText(String.valueOf(resultado));
            }
        });

        Button sub = (Button) findViewById(R.id.button6);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valor1 = Float.parseFloat(Valor1.getText().toString());
                float valor2 = Float.parseFloat(Valor2.getText().toString());
                float resultado = valor1 - valor2;
                Resultado.setText(String.valueOf(resultado));
            }
        });

        Button mult = (Button) findViewById(R.id.button4);
        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valor1 = Float.parseFloat(Valor1.getText().toString());
                float valor2 = Float.parseFloat(Valor2.getText().toString());
                float resultado = valor1 * valor2;
                Resultado.setText(String.valueOf(resultado));
            }
        });

        Button div = (Button) findViewById(R.id.button5);
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float valor1 = Float.parseFloat(Valor1.getText().toString());
                float valor2 = Float.parseFloat(Valor2.getText().toString());
                if (valor2 != 0) {
                    float resultado = valor1 / valor2;
                    Resultado.setText(String.valueOf(resultado));
                } else {
                    Resultado.setText("Divisão por zero!");
                }
            }
        });

        Button LimparValor1 = (Button) findViewById(R.id.button7);
        Button LimparValor2 = (Button) findViewById(R.id.button8);
        Button LimparTudo = (Button) findViewById(R.id.button9);
        Button CopiarResultadoParaValor1 = (Button) findViewById(R.id.button10);

        LimparValor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valor1.setText("");
            }
        });

        LimparValor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valor2.setText("");
            }
        });

        LimparTudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Valor1.setText("");
                Valor2.setText("");
                Resultado.setText("RESULTADO:");
            }
        });

        CopiarResultadoParaValor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res = Resultado.getText().toString().replace("RESULTADO:", "").trim();
                Valor1.setText(res);
            }
        });
    }
}
