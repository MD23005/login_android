package com.example.login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        //Obtener los botones
        Button btnGuardar = findViewById(R.id.btnSave);
        Button btnRegresar = findViewById(R.id.btnRegresar);

        //Obtener los edit text
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtConfirmPassword = findViewById(R.id.edtConfirmPassword);

        //Declarar el event listener para el botón guardar
        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener los valores de los edit text
                String username = edtUsername.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();

                //validar tamaño del username
                if(username.length() < 3 || username == null){
                    //mostrar advertencia
                    edtUsername.setError("El nombre de usuario no puede estar vacío o tener menos de 3 caracteres");
                    Toast.makeText(MainActivity.this, "El nombre de usuario debe tener 3 o más caracteres", Toast.LENGTH_LONG).show();
                    return;
                }

                //validar email
                if( email == null || email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    //mostrar advertencia
                    edtUsername.setError("El email contiene errores");
                    Toast.makeText(MainActivity.this, "El email debe tener el formato correcto y no puede estar vacío", Toast.LENGTH_LONG).show();
                    return;
                }

                //validar contraseña
                if( password == null || password.isEmpty() || password.length() < 5){
                    //mostrar advertencia
                    edtPassword.setError("La contraseña debe tener al menos 5 caracteres");
                    Toast.makeText(MainActivity.this, "La contraseña debe tener al menos 5 caracteres", Toast.LENGTH_LONG).show();
                    return;
                }

                //validar confirmacion de contraseña
                if(!password.equals(confirmPassword)){
                    //mostrar advertencia
                    edtConfirmPassword.setError("Las contraseñas no coinciden");
                    Toast.makeText(MainActivity.this, "Debe escribir la misma contraseña en ambos campos", Toast.LENGTH_LONG).show();
                    return;
                }

                //Guardar los datos en shared preferences
                guardarEnSharedPreferences(username, email, password);
            }
        });

        //Función del botón regresar
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Regresar a la actividad anterior
                finish();
            }
        });
    }

    //Función para guardar los datos en shared preferences
    private void guardarEnSharedPreferences(String username, String email, String password){
        //Declrar el archivo shared preferences
        SharedPreferences preferences = getSharedPreferences("Users", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        //Guardar los datos en formato clave-valor
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);

        //aplicamos los cambios
        editor.apply();

        //mostrar mensaje de éxito
        Toast.makeText(MainActivity.this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show();
    }
}