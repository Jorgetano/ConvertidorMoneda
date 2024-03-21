package com.examples.convertidormoneda;

import static com.examples.convertidormoneda.R.id.BConvertir;
import static com.examples.convertidormoneda.R.id.Resultado;
import static com.examples.convertidormoneda.R.id.textView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView Pesos, Resultado, ResultadoDolares;
    Button Boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Boton = findViewById(R.id.BConvertir);
        Pesos = findViewById(R.id.Peso);
        Resultado = findViewById(R.id.Resultado);
        ResultadoDolares = findViewById(R.id.ResultadoDolares);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirPesosAEuros();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void convertirPesosAEuros() {
        try {
            double pesos = Double.parseDouble(Pesos.getText().toString());
            double CambioEuros = 0.00024;
            double CambioDolares = 0.00026;
            double euros = pesos * CambioEuros;
            double Dolares = pesos * CambioDolares;

            Resultado.setText(pesos + " pesos equivalen a " + euros + " euros.");
            ResultadoDolares.setText(pesos + " pesos equivalen a " + Dolares + " Dolares.");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Error: Ingresa un número válido.", Toast.LENGTH_SHORT).show();
        }
    }


}


