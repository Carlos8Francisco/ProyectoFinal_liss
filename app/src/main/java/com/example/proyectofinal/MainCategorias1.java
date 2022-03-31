package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainCategorias1 extends AppCompatActivity {

    ImageButton b1,b2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_categorias1);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        t1 = findViewById(R.id.cerrar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(MainCategorias1.this, listcate.class));


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainCategorias1.this, historial.class));

            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainCategorias1.this, MainActivity.class));
                Toast.makeText(MainCategorias1.this, "Cerraste Sesion", Toast.LENGTH_SHORT).show();

            }
        });
    }


}