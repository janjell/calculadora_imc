package cl.janjel.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtKilos;
    private EditText txtCentimetros;
    private TextView lblResultado;
    private Button btnProcesar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKilos = findViewById(R.id.txtPeso);
        txtCentimetros = findViewById(R.id.txtEstatura);
        lblResultado = findViewById(R.id.lblResultado);
        btnProcesar = findViewById(R.id.btnProcesar);
        main();
    }

    private void main() {
        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double imc;
                double kg;
                double cm;

                kg = Double.parseDouble(txtKilos.getText().toString());
                cm = Double.parseDouble(txtCentimetros.getText().toString());

                imc = kg / (cm * cm);

                if (imc < 16.00) {
                    lblResultado.setText("Delgadez Severa");
                } else if (imc <= 16.00 || imc <= 17.00) {
                    lblResultado.setText("Delgadez Moderada");
                } else if (imc <= 17.00 || imc <= 18.5) {
                    lblResultado.setText("Delgadez Aceptable");
                } else if (imc <= 18.5 || imc <= 25.00) {
                    lblResultado.setText("Normal");
                } else if (imc <= 25.00 || imc <= 30.00) {
                    lblResultado.setText("Pre-Obeso");
                } else if (imc <= 30.00 || imc <= 35.00) {
                    lblResultado.setText("Obeso Tipo I");
                } else if (imc <= 35.00 || imc <= 40.00) {
                    lblResultado.setText("Obeso Tipo II");
                } else if (imc <= 40.00) {
                    lblResultado.setText("Obeso Tipo III");
                }else{
                    lblResultado.setText("No lo se rick, parece falso.");
                }
            }
        });
    }
}
