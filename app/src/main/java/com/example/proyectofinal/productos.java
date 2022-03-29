package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class productos extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        tv1 = findViewById(R.id.tvp1);
        tv2 = findViewById(R.id.tvpr1);
        tv3 = findViewById(R.id.tvp2);
        tv4 = findViewById(R.id.tvpr2);
        tv5 = findViewById(R.id.tvp3);
        tv6 = findViewById(R.id.tvpr3);

        Intent intent=getIntent();
        position =intent.getExtras().getInt("position");

        tv1.setText("nombre: " + listcate.categoriasArrayList.get(position).getNombre());
        tv2.setText("cantidad: " + listcate.categoriasArrayList.get(position).getCantidad());
        tv3.setText("nombre: " + listcate.categoriasArrayList.get(position).getNombre2());
        tv4.setText("cantidad: " + listcate.categoriasArrayList.get(position).getCantidad2());
        tv5.setText("nombre: " + listcate.categoriasArrayList.get(position).getNombre3());
        tv6.setText("cantidad: " + listcate.categoriasArrayList.get(position).getCantidad3());
    }
}