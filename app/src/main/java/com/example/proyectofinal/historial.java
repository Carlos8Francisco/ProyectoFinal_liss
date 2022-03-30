package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class historial extends AppCompatActivity {

    private ListView listaProductos;
    private ArrayList<producto> list_product;
    private productoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);
        listaProductos = (ListView) findViewById(R.id.Listproduct);
        list_product  = new ArrayList<>();
        GetListaFromServer();

    }

    private void LlenarLista() {
        adapter = new productoAdapter(this,R.layout.itempedido,list_product);
        listaProductos.setAdapter(adapter);
    }

    private void GetListaFromServer() {
        RequestQueue queque = Volley.newRequestQueue(this);
        String url = "https://pruebafd1.000webhostapp.com/loginphp/index.php?lista2={\"user\":\"carlos\",\"password\":\"1234\"}";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response.optString("Status").equals("success")){
                    String data = response.optString("Datos");
                    try {
                        JSONArray jsonArray = new JSONArray(data);
                        for(int i=0;i<jsonArray.length(); i++){
                            JSONObject jsonObject = new JSONObject();
                            jsonObject = jsonArray.getJSONObject(i);
                            list_product.add(new producto(jsonObject.optString("nombre"),jsonObject.optString("direccion"),jsonObject.optString("total")));

                        }
                        LlenarLista();
                    }catch (JSONException e){
                        Toast.makeText(getApplicationContext(),"Error:"+ e.getMessage(),Toast.LENGTH_LONG).show();
                    }


                }else{

                    Toast.makeText(getApplicationContext(),"Credenciales Incorrectas",Toast.LENGTH_LONG).show();

                }

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Te falto un punto y coma :(", Toast.LENGTH_LONG).show();
            }
        });
        queque.add(jsonObjectRequest);
    }
}