package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class ConsultarClienteAdmin extends AppCompatActivity {

    Button consultarCliente,cancelarConsultarCliente ;
    ImageView volveritem;
    TextView tvConsultar;
    TextInputLayout textInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.consultar_admin );
        consultarCliente = findViewById(R.id.btnConfirmaDatosCliente );
        cancelarConsultarCliente = findViewById(R.id.btnCancelarDatosCliente );
        volveritem = findViewById(R.id.volveritem);
        tvConsultar = findViewById(R.id.tvIngresarPin );
        textInputLayout = findViewById(R.id.numeroConsultar);


        tvConsultar.setText("Consultar cliente");
        textInputLayout.setHint( "Ingrese el numero de cedula" );




        consultarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.muestra_datos_cliente_creado);
            }
        } );

        cancelarConsultarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarClienteAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );


        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarClienteAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );


    }
}