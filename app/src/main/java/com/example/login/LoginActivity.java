package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
            // Tu código aquí
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
