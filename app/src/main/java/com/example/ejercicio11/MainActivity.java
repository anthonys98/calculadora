package com.example.ejercicio11;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumber1;
    private EditText edtNumber2;
    private Button btnSum;
    private Button btnResta;
    private Button btnMultiplicacion;
    private Button btnDivision;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        btnSum = findViewById(R.id.btnSum);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        tvResultado = findViewById(R.id.tvResultado);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("+");
            }
        });

        btnResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("-");
            }
        });

        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("*");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado("/");
            }
        });
    }

    private void calcularResultado(String operacion) {
        String numero1Str = edtNumber1.getText().toString();
        String numero2Str = edtNumber2.getText().toString();

        if (numero1Str.isEmpty() || numero2Str.isEmpty()) {
            Toast.makeText(MainActivity.this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        double numero1 = Double.parseDouble(numero1Str);
        double numero2 = Double.parseDouble(numero2Str);
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    Toast.makeText(MainActivity.this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        tvResultado.setText("Resultado: " + resultado);
    }
}
