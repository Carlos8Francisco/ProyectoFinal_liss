package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class exito extends AppCompatActivity {

    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exito);
        t1=(TextView) findViewById(R.id.tx1);
        b1=(Button) findViewById(R.id.btn1);

        String dato = getIntent().getStringExtra("dato");
        String dato2 = getIntent().getStringExtra("dato2");
        String dato3 = getIntent().getStringExtra("dato3");

        t1.setText("Hola estimado "+dato+ " su pedido fue un exito, llegaremos en breve a su colonia: "+dato3+" y al llegar a su domicilio nos comunicaremos al telefono: "+dato2+", para entregarle su pedido, Gracias por usar nuestra APP");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(exito.this, MainCategorias1.class));

            }
        });
    }
}