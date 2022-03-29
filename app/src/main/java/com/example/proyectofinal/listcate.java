package com.example.proyectofinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class listcate extends AppCompatActivity {

    ListView listView;
    Adapter adapter;

    public static ArrayList<Categorias>categoriasArrayList=new ArrayList<>();
    String url = "https://pruebafd1.000webhostapp.com/loginphp/mostrar.php";
    Categorias categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcate);
        listView = findViewById(R.id.List1);
        adapter = new Adapter(this,categoriasArrayList);
        listView.setAdapter(adapter);
        ListarDatos();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                startActivity(new Intent(getApplicationContext(),productos.class).putExtra("position",position));
                Toast.makeText(listcate.this, "Realiza tu pedido", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ListarDatos() {
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                categoriasArrayList.clear();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String exito = jsonObject.getString("exito");
                    JSONArray jsonArray = jsonObject.getJSONArray("datos");
                    if (exito.equals("1")) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String id = object.getString("id");
                            String categoria = object.getString("categoria");
                            String nombre = object.getString("nombre");
                            String cantidad = object.getString("cantidad");
                            String nombre2 = object.getString("nombre2");
                            String cantidad2 = object.getString("cantidad2");
                            String nombre3 = object.getString("nombre3");
                            String cantidad3 = object.getString("cantidad3");

                            categorias = new Categorias(id, categoria, nombre, cantidad, nombre2, cantidad2, nombre3, cantidad3);
                            categoriasArrayList.add(categorias);
                            adapter.notifyDataSetChanged();

                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(listcate.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}