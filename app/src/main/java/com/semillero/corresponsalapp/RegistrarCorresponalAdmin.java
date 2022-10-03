package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class RegistrarCorresponalAdmin extends AppCompatActivity {

    Button crearCorresponsal,cancelarCrearCorresponsal ;
    ImageView volveritem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registrar_corresponal_admin );
        crearCorresponsal = findViewById(R.id.btnConfirmarCorresponsal);
        cancelarCrearCorresponsal = findViewById(R.id.btnCancelarCorresponsal);
        volveritem = findViewById(R.id.volveritem);



        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarCorresponalAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );





        crearCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        } );



        cancelarCrearCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarCorresponalAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );
    }
}