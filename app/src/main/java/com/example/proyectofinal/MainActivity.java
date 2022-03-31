package com.example.proyectofinal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class MainActivity extends AppCompatActivity {

    private EditText email, contraseña;
    private Button btn1;
    private TextView salida;
    String editxt_email,editxt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.etemail);
        contraseña = findViewById(R.id.etcontraseña);
        btn1 = findViewById(R.id.b1);
        salida = findViewById(R.id.salir);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, register.class));
            }
        });

        salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, exit.class));
            }
        });

    }

    //string url del servidor web
    String url = "https://pruebafd1.000webhostapp.com/loginphp/loguear.php";

    //Metodo onclick ejecucion para iniciar sesión

    public void login(View view){

        //Condicional si existe o no datos dentro de los edittex para el inicio de sesión, si existe el dato guardado en la base de datos -
        //si existe el usuario se encuentra registrado se inicia sesion para posterior pasar a la siguiente ventana.

        if(email.getText().toString().equals("") && contraseña.getText().toString().equals("")){

            Toast.makeText(this, "Ingresa tu Correo y Contraseña, por favor", Toast.LENGTH_SHORT).show();

        }else if(email.getText().toString().equals("")){

            Toast.makeText(this, "Ingresa tu Correo correspondiente", Toast.LENGTH_SHORT).show();

        }else if(contraseña.getText().toString().equals("")){

            Toast.makeText(this, "Ingresa tu contraseña correspondiente", Toast.LENGTH_SHORT).show();

        }else{

            //en caso de ingresar correctamente los datos este ejecuta el inicio de sesion
            // usando el url como referencia de los datos y conexion bd

            editxt_email = email.getText().toString().trim();
            editxt_password = contraseña.getText().toString().trim();

            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String condicion) {


                    if (condicion.equalsIgnoreCase("ingresaste correctamente")) {
                        email.setText("");
                        contraseña.setText("");
                        startActivity(new Intent(getApplicationContext(), MainCategorias1.class));
                        //Mensaje de inicio correctamente
                        Toast.makeText(MainActivity.this, condicion, Toast.LENGTH_SHORT).show();

                    } else {
                        //Mensaje de sesion incorrecta
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
                //En caso de error en el sistema saldra
            }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "te falto un punto y coma :(", Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> condicion = new HashMap<String, String>();
                        condicion.put("email",editxt_email);
                        condicion.put("contraseña",editxt_password);
                        return condicion;
                    }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
            requestQueue.add(request);
        }
    }




}