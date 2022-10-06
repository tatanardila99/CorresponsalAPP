package com.semillero.corresponsalapp.ViewsAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.semillero.corresponsalapp.ModelMain.InterfaceMain;
import com.semillero.corresponsalapp.ModelMain.ModelMain;
import com.semillero.corresponsalapp.PresenterMain.PresenterMain;
import com.semillero.corresponsalapp.R;

public class LoginMain extends AppCompatActivity implements InterfaceMain.LoginView, View.OnClickListener {


    TextInputEditText emailLogin;
    TextInputEditText passwordLogin;
    Button btnInicarSesion;
    private PresenterMain presenterMain;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.login_main );
        emailLogin = (TextInputEditText) findViewById(R.id.emailLogin);
        passwordLogin = (TextInputEditText)  findViewById(R.id.passwordLogin);
        btnInicarSesion = findViewById(R.id.btnIniciarSesion);
        btnInicarSesion.setOnClickListener(this);

        presenterMain = new PresenterMain(this, new ModelMain() );

    }



    //IMPLEMENTACION DE METODOS DE LA INTERFAZ DEL VIEW

    @Override
    public void setUsuarioError() {
        emailLogin.setError("Error usuario");

    }

    @Override
    public void setContrasenaError() {
        passwordLogin.setError("Error password");

    }

    //METODO ONCLICK DE LA VISTA LOGIN

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "BIENVENIDO CRACK :')", Toast.LENGTH_LONG).show();
        presenterMain.validarCredenciales(this,  emailLogin.getText().toString(), passwordLogin.getText().toString() );
    }
}