package com.example.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PerfilFragment extends Fragment {

        // Constructor vacío requerido por Android para los fragments
    public PerfilFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflamos el layout del fragmento
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Leemos usuario y email guardados en SharedPreferences
        SharedPreferences preferences = requireActivity()
                .getSharedPreferences("Users", requireActivity().MODE_PRIVATE);
        String username = preferences.getString("username", "Usuario");
        String email = preferences.getString("email", "Sin email");

        // Mostramos la primera letra del usuario en el círculo avatar
        TextView txtAvatar = view.findViewById(R.id.txtAvatar);
        txtAvatar.setText(username.substring(0, 1).toUpperCase());

        // Mostramos el nombre grande debajo del avatar
        TextView txtNombre = view.findViewById(R.id.txtPerfilNombre);
        txtNombre.setText(username);

        // Mostramos el email debajo del nombre
        TextView txtEmail = view.findViewById(R.id.txtPerfilEmail);
        txtEmail.setText(email);

        // Mostramos usuario y email también en las filas de detalle
        TextView txtUsuario2 = view.findViewById(R.id.txtPerfilUsuario2);
        txtUsuario2.setText(username);

        TextView txtEmail2 = view.findViewById(R.id.txtPerfilEmail2);
        txtEmail2.setText(email);

        // Botón salir que regresa al Login
        Button btnSalir = view.findViewById(R.id.btnSalirPerfil);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrimos el LoginActivity
                Intent intent = new Intent(requireActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                requireActivity().finish();
            }
        });
        // Retornamos la vista con todos los datos cargados
        return view;
    }
}