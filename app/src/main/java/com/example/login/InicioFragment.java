package com.example.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InicioFragment extends Fragment {

    public InicioFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        // Leemos el nombre de usuario guardado en SharedPreferences
        SharedPreferences preferences = requireActivity()
                .getSharedPreferences("Users", requireActivity().MODE_PRIVATE);
        String username = preferences.getString("username", "Usuario");

        // Mostramos el nombre en el TextView
        TextView txtNombre = view.findViewById(R.id.txtNombreUsuario);
        txtNombre.setText("Hola, " + username + "!");

        return view;
    }
}