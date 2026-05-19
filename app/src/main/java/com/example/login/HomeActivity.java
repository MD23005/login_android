package com.example.login;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //vinculamos el bottom navigation con el fragment
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        //fragmento por defcto
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new InicioFragment()).commit();

        }

        //configurar el evento onclick del menu
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                int itemId = item.getItemId();

                if(itemId == R.id.menu_inicio){
                    fragment = new InicioFragment();
                }else if(itemId == R.id.menu_productos){
                    fragment = new ProductFragment();
                }else if(itemId == R.id.menu_perfil){
                    fragment = new PerfilFragment();
                }

                //cambiar el fragmento
                if(fragment != null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
                    return true;
                }

                return false;
            }
        });
    }
}
