package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Crear los botones de acción
        Button btnIngresar = findViewById(R.id.btnIngresar);
        Button btnSalir = findViewById(R.id.btnSalir);

        //Función del botón ingresar
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //Creamos variable para gestionar las sharedPreferences
                SharedPreferences preferences = getSharedPreferences("Users", MODE_PRIVATE);

                //Almacenamos los datos obtenidos de las shared preferences
                String username = preferences.getString("username", "");
                String password = preferences.getString("password", "");

                if(username.isEmpty() && password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Usuario y contraseña no coinciden", Toast.LENGTH_LONG).show();
                    return;
                }

                Toast.makeText(LoginActivity.this, "Bienvenido, " + username, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

                //redirigir al home
                startActivity(intent);
            }
        });

        //Función del botón salir
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Salir de la aplicación
                finishAffinity();
            }
        });

    }

    // Función para inflar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_toolbar_menu, menu);
        return true;
    }

    // Función para manejar la selección de un elemento del menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.registrar_action) {
            // Crear el intent
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            // iniciar la actividad
            startActivity(intent);
            return true;
        } else if (id == R.id.salir_action) {
            //salir de la aplicación
            finishAffinity();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
