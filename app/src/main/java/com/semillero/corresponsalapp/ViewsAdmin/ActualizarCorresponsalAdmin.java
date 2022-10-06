package com.semillero.corresponsalapp.ViewsAdmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;
import com.semillero.corresponsalapp.R;

public class ActualizarCorresponsalAdmin extends AppCompatActivity {

    Button actualizarCorresponsal,CancelaractualizarCorresponsal;
    ImageView volveritem;
    TextView tvRegisActualizarCliente;
    TextInputLayout corresponsalnombre;
    TextInputLayout corresponsalnit;
    TextInputLayout corresponsalcorreo;
    TextInputLayout corresponsalcontrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registrar_corresponal_admin);
        actualizarCorresponsal = findViewById(R.id.btnConfirmaDatosCliente );
        CancelaractualizarCorresponsal = findViewById(R.id.btnCancelarDatosCliente );
        tvRegisActualizarCliente = findViewById(R.id.tvRegisActualizarCliente);
        corresponsalnombre = (TextInputLayout ) findViewById(R.id.corresponsalnombre);
        corresponsalnit =  (TextInputLayout ) findViewById(R.id.corresponsalnit);
        corresponsalcorreo =  (TextInputLayout ) findViewById(R.id.corresponsalcorreo);
        corresponsalcontrasena =  (TextInputLayout ) findViewById(R.id.corresponsalcontraseña);
        volveritem = findViewById(R.id.volveritem);


        tvRegisActualizarCliente.setText("Actualizar Corresponsal");
        corresponsalnombre.setHint("Nombre corresponsal");
        corresponsalnit.setHint("Numero de NIT");
        corresponsalcorreo.setHint("Correo electronico");
        corresponsalcontrasena.setHint("Contraseña");




        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActualizarCorresponsalAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );





        actualizarCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        } );



        CancelaractualizarCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertcancel);
                Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertCancel);
                tvCancelarActcorresponsal.setText("ACTUALIZACION CORRESPONSAL CANCELADA");


                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(ActualizarCorresponsalAdmin.this, Inicio_administrador.class);
                        startActivity(intent);
                    }
                } );

            }
        } );
    }
}
