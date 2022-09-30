package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.semillero.corresponsalapp.Interactor.MainInterfaces;

public class LoginMain extends AppCompatActivity implements MainInterfaces.LoginView, View.OnClickListener {


    TextInputLayout emailLogin;
    TextInputLayout passwordLogin;
    Button btnInicarSesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login_main );
//        emailLogin = (TextInputLayout) findViewById(R.id.emailLogin);
//        passwordLogin = (TextInputLayout)  findViewById(R.id.passwordLogin);
        btnInicarSesion = findViewById(R.id.btnIniciarSesion);
        btnInicarSesion.setOnClickListener(this);
    }


    //IMPLEMENTACION DE METODOS DE LA INTERFAZ DEL VIEW

    @Override
    public void setUsuarioError() {
        emailLogin.setError("Ingrese un correo");

    }

    @Override
    public void setContrasenaError() {
        passwordLogin.setError("Error de contraseña");

    }

    @Override
    public void setErrorIngreso() {
        Toast.makeText(getApplicationContext(), "Usuario y/o contraseña Incorrectos", Toast.LENGTH_LONG).show();

    }



    //METODO ONCLICK DE LA VISTA LOGIN

    @Override
    public void onClick(View view) {

    }
}