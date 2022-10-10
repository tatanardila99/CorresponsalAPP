package com.semillero.corresponsalapp.ViewsAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import com.semillero.corresponsalapp.R;

public class LoginMainView extends AppCompatActivity   {


    TextInputEditText emailLogin;
    TextInputEditText passwordLogin;
    Button btnInicarSesion;
    //private PresenterMain presenterMain;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login_main );
        emailLogin = (TextInputEditText) findViewById(R.id.emailLogin);
        passwordLogin = (TextInputEditText)  findViewById(R.id.passwordLogin);
        btnInicarSesion = findViewById(R.id.btnIniciarSesion);
       // btnInicarSesion.setOnClickListener(this);

        //presenterMain = new PresenterMain(this, new ModelMain() );

    }



    //IMPLEMENTACION DE METODOS DE LA INTERFAZ DEL VIEW



    //METODO ONCLICK DE LA VISTA LOGIN

}