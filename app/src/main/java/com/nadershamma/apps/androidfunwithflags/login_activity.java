package com.nadershamma.apps.androidfunwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

import DatosUser.UserData;

import Entities.User;


public class login_activity extends AppCompatActivity {
    private EditText edit_nombre;
    private EditText edit_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // KF
        edit_nombre = findViewById(R.id.editText_nombre);
        edit_pass = findViewById(R.id.editText_password);

    }
    public void IniciarSesion(View view){

        UserData usuarioDatos = new UserData(this);{
            User usuario = usuarioDatos.login(edit_nombre.getText().toString(), edit_pass.getText().toString());

            if(usuario != null)
            {
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("cedula", (usuario.getCedula()));
                intent.putExtra("nombre1", (usuario.getNombre()));
                intent.putExtra("apellido", (usuario.getApellido()));
                intent.putExtra("clave", (usuario.getClave()));
                intent.putExtra("correo", (usuario.getCorreo()));
                intent.putExtra("nombre", (usuario.getNombre() + " " + usuario.getApellido()));
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Login Incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    public void Registrar(View view){
        Intent intent = new Intent(this, RegistrarActivity.class);
        startActivity(intent);
    }
}