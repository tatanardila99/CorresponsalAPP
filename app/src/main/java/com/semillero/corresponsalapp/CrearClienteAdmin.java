package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CrearClienteAdmin extends AppCompatActivity {

    Button crearCliente,cancelarCrearCliente;
    ImageView volveritem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.crear_cliente);
        crearCliente = findViewById(R.id.btnConfirmarCliente);
        cancelarCrearCliente = findViewById(R.id.btnCancelarCliente);
        volveritem = findViewById(R.id.volveritem);






        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearClienteAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );



        crearCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        } );



        cancelarCrearCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearClienteAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );
    }



}