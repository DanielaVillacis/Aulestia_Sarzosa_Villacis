package com.nadershamma.apps.androidfunwithflags;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import DatosUser.UserData;

public class RegistrarAuxActivity extends AppCompatActivity {

    private EditText textCedula;
    private EditText textNombre;
    private EditText textApellido;
    private EditText textCorreo;
    private EditText textClave;
    //private String correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        textCedula = findViewById(R.id.txt_cedula);
        String cedula=getIntent().getExtras().getString("cedula");

        if (cedula.isEmpty()) {textCedula.setText("");}
        else   {textCedula.setText(cedula);}

        textNombre = findViewById(R.id.txt_nombre);
        String nombre1=getIntent().getExtras().getString("nombre1");

        if (nombre1.isEmpty()) {textCedula.setText("");}
        else   {textNombre.setText(nombre1);}

        textApellido = findViewById(R.id.txt_apellido);
        String apellido=getIntent().getExtras().getString("apellido");

        if (apellido.isEmpty()) {textApellido.setText("");}
        else   {textApellido.setText(apellido);}

        textCorreo = findViewById(R.id.txt_correo);

        String correo=getIntent().getExtras().getString("correo");

        if (correo.isEmpty()) {textCorreo.setText("");}
        else   {textCorreo.setText(correo);}

        textClave = findViewById(R.id.txt_clave);

        String clave=getIntent().getExtras().getString("clave");

        if (clave.isEmpty()) {textClave.setText("");}
        else   {textClave.setText(clave);}
    }

    public void Salir(View view){
        Intent intent = new Intent(this, login_activity.class);
        startActivity(intent);
    }

    public void RegistrarUsuario(View view){
        String cedula = textCedula.getText().toString();
        String nombre = textNombre.getText().toString();
        String apellido = textApellido.getText().toString();
        String correo = textCorreo.getText().toString();
        String clave = textClave.getText().toString();

        if(!cedula.equals("") && !nombre.equals("") && !apellido.equals("") && !correo.equals("") && !clave.equals("")){
            UserData usuarioDatos = new UserData(this);
            long id =usuarioDatos.insertarUsuario(cedula, nombre, apellido, correo, clave);

            if(id > 0){
                Toast.makeText(this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                Limpiar();
            }else
                Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_LONG).show();

        }else
            Toast.makeText(this, "Llene los campos", Toast.LENGTH_LONG).show();

    }


    private void Limpiar(){
        textCedula.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textCorreo.setText("");
        textClave.setText("");
    }
}