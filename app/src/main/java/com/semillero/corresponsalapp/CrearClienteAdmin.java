package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CrearClienteAdmin extends AppCompatActivity {

    Button btncrearCliente,cancelarCrearCliente;
    ImageView volveritem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.crear_cliente);
        btncrearCliente = findViewById(R.id.btnConfirmarCliente);
        cancelarCrearCliente = findViewById(R.id.btnCancelarCliente);
        volveritem = findViewById(R.id.volveritem);



        btncrearCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearClienteAdmin.this, Confirmar_Pin.class);
                startActivity(intent);

            }
        } );


        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CrearClienteAdmin.this, Inicio_administrador.class);
                startActivity(intent);
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