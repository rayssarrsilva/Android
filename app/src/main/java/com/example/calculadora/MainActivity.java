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

    // Variável para armazenar o valor da memória
    private float memoria = 0f;

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

        // Referência dos elementos
        EditText valor1 = findViewById(R.id.editTextText);
        EditText valor2 = findViewById(R.id.editTextText2);
        TextView resultado = findViewById(R.id.textView);

        Button btnSoma = findViewById(R.id.button3);
        Button btnSub = findViewById(R.id.button6);
        Button btnMult = findViewById(R.id.button4);
        Button btnDiv = findViewById(R.id.button5);

        Button btnLimparValor1 = findViewById(R.id.button7);
        Button btnLimparValor2 = findViewById(R.id.button8);
        Button btnLimparTudo = findViewById(R.id.button9);
        Button btnCopiarResultado = findViewById(R.id.button10);

        // Botões de memória
        Button btnMmais = findViewById(R.id.button11); // M+
        Button btnMmenos = findViewById(R.id.button14); // M-
        Button btnMR = findViewById(R.id.button12); // MR
        Button btnMC = findViewById(R.id.button13); // MC

        // Operações
        btnSoma.setOnClickListener(v -> {
            float v1 = Float.parseFloat(valor1.getText().toString());
            float v2 = Float.parseFloat(valor2.getText().toString());
            resultado.setText(String.valueOf(v1 + v2));
        });

        btnSub.setOnClickListener(v -> {
            float v1 = Float.parseFloat(valor1.getText().toString());
            float v2 = Float.parseFloat(valor2.getText().toString());
            resultado.setText(String.valueOf(v1 - v2));
        });

        btnMult.setOnClickListener(v -> {
            float v1 = Float.parseFloat(valor1.getText().toString());
            float v2 = Float.parseFloat(valor2.getText().toString());
            resultado.setText(String.valueOf(v1 * v2));
        });

        btnDiv.setOnClickListener(v -> {
            float v1 = Float.parseFloat(valor1.getText().toString());
            float v2 = Float.parseFloat(valor2.getText().toString());
            if (v2 != 0) {
                resultado.setText(String.valueOf(v1 / v2));
            } else {
                resultado.setText("Divisão por zero!");
            }
        });

        // Funções extras
        btnLimparValor1.setOnClickListener(v -> valor1.setText(""));
        btnLimparValor2.setOnClickListener(v -> valor2.setText(""));
        btnLimparTudo.setOnClickListener(v -> {
            valor1.setText("");
            valor2.setText("");
            resultado.setText("RESULTADO:");
        });

        btnCopiarResultado.setOnClickListener(v -> {
            String res = resultado.getText().toString().replace("RESULTADO:", "").trim();
            valor1.setText(res);
        });

        // Funções de memória
        btnMmais.setOnClickListener(v -> {
            String res = resultado.getText().toString().replace("RESULTADO:", "").trim();
            if (!res.isEmpty()) {
                memoria += Float.parseFloat(res);
            }
        });

        btnMmenos.setOnClickListener(v -> {
            String res = resultado.getText().toString().replace("RESULTADO:", "").trim();
            if (!res.isEmpty()) {
                memoria -= Float.parseFloat(res);
            }
        });

        btnMR.setOnClickListener(v -> {
            valor1.setText(String.valueOf(memoria));
        });

        btnMC.setOnClickListener(v -> {
            memoria = 0f;
        });
    }
}
