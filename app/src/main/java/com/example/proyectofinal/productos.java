package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class productos extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6,totalv7;
    EditText nombre, direccion, c1, c2, c3;
    Button pedido, cancelar;
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
        totalv7 = findViewById(R.id.total);
        //edit y botones
        nombre    = findViewById(R.id.nombre);
        direccion = findViewById(R.id.direccion);
        c1 = findViewById(R.id.ed_can1_ins);
        c2 = findViewById(R.id.ed_can2_ins);
        c3 = findViewById(R.id.ed_can3_ins);
        pedido = findViewById(R.id.pedido1);
        cancelar = findViewById(R.id.cclr);



        Intent intent=getIntent();
        position =intent.getExtras().getInt("position");

        tv1.setText("Producto: " + listcate.categoriasArrayList.get(position).getNombre());
        tv2.setText(listcate.categoriasArrayList.get(position).getCantidad());
        tv3.setText("Producto: " + listcate.categoriasArrayList.get(position).getNombre2());
        tv4.setText(listcate.categoriasArrayList.get(position).getCantidad2());
        tv5.setText("Producto: " + listcate.categoriasArrayList.get(position).getNombre3());
        tv6.setText(listcate.categoriasArrayList.get(position).getCantidad3());



        //onclicks botones
        pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String Total = TotalPedido(c1.getText().toString(),c2.getText().toString(),c3.getText().toString(),tv2.getText().toString(),tv4.getText().toString(),tv6.getText().toString());
                //String Total = TotalPedido(c1.getText().toString(),c2.getText().toString(),c3.getText().toString());
                InsertarPedido(nombre.getText().toString(), direccion.getText().toString(), Total);
                startActivity(new Intent(productos.this, MainCategorias1.class)); //stars ultimo modify

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(productos.this, MainCategorias1.class)); //stars ultimo modify

            }
        });


    }


    private void InsertarPedido(String nombre_i, String direccion_i, String total_i) {
        RequestQueue queque = Volley.newRequestQueue(this);
        String url = "https://pruebafd1.000webhostapp.com/loginphp/index.php?insert={\"nombre\":\""+nombre_i+"\",\"direccion\":\""+direccion_i+"\",\"total\":\""+total_i+"\"}";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                if (response.optString("Status").equals("success")) {
                    Toast.makeText(getApplicationContext(), " " + response.optString("Mensaje"), Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Server:" + response.optString("Mensaje"), Toast.LENGTH_LONG).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Te falta un punto y coma :(", Toast.LENGTH_LONG).show();

            }
        });

        queque.add(jsonObjectRequest);

    }


    private String TotalPedido(String c1, String c2, String c3, String tv2, String tv4, String tv6)
    /*private String TotalPedido(String c1, String c2, String c3)*/ {



        Double Cantidad1 = Double.valueOf(c1);
        Double Cantidad2 = Double.valueOf(c2);
        Double Cantidad3 = Double.valueOf(c3);
        Double Precio1 = Double.valueOf(tv2);
        Double Precio2 = Double.valueOf(tv4);
        Double Precio3 = Double.valueOf(tv6);

        Double Total = (Cantidad1 * Precio1) + (Cantidad2 * Precio2) + (Cantidad3 * Precio3);
        //Double Total = Cantidad1 + Cantidad2 + Cantidad3;

        return ""+Total;

    }


}