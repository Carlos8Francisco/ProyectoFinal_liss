package com.example.proyectofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {

    EditText Edt_Name,Edt_Email,Edt_pass;
    Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Edt_Name = findViewById(R.id.ednombre);
        Edt_Email = findViewById(R.id.etemail);
        Edt_pass = findViewById(R.id.etcontraseña);
        btn_1 = findViewById(R.id.btn_register);

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
            }

        });
    }

    //Metodo Insertar los datos del registro para su posterior conexion e inserccion de datos en la bd

    private void insertData() {

        String nombre = Edt_Name.getText().toString().trim();
        String correo = Edt_Email.getText().toString().trim();
        String contraseña = Edt_pass.getText().toString().trim();

        //Metodo Condicional de inserccion de datos en el formulario registro no tiene los campos llenos no inicia proceso
        //Si tiene los datos iniciados esta inicia para guardar los datos en bd con ayuda del webservices que permite la conexión

        if(correo.isEmpty() && nombre.isEmpty() && contraseña.isEmpty()){
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();

            return;
        }else if(nombre.isEmpty() && correo.isEmpty()){

            Toast.makeText(this, "Completa los campos faltantes", Toast.LENGTH_SHORT).show();
            return;
        }else if(correo.isEmpty() && contraseña.isEmpty()){

            Toast.makeText(this, "Completa los campos faltantes", Toast.LENGTH_SHORT).show();
            return;
        }else if(nombre.isEmpty() && contraseña.isEmpty()){

            Toast.makeText(this, "Completa los campos faltantes", Toast.LENGTH_SHORT).show();
            return;
        }else if(nombre.isEmpty()){

            Toast.makeText(this, "Complete el campo Nombre", Toast.LENGTH_SHORT).show();
            return;
        }else if(correo.isEmpty()){

            Toast.makeText(this, "Complete el campo Correo", Toast.LENGTH_SHORT).show();
            return;
        }else if(contraseña.isEmpty()){

            Toast.makeText(this, "Complete el campo Contraseña", Toast.LENGTH_SHORT).show();
            return;
        }else{

            //Pasa los parametro de llenado de campos para iniciar registro e insertar datos en la tabla de la bd

            StringRequest request = new StringRequest(Request.Method.POST, "https://pruebafd1.000webhostapp.com/loginphp/insertar.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos Insertados")) {

                        Toast.makeText(register.this, "Datos no insertados", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(register.this, MainActivity.class);
                        startActivity(intent);
                    }

                }
                //En caso de error en el sistema saldra
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(register.this, "te falto un punto y coma :(", Toast.LENGTH_SHORT).show();

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();

                    params.put("nombre",nombre);
                    params.put("email",correo);
                    params.put("contraseña",contraseña);

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(register.this);
            requestQueue.add(request);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}