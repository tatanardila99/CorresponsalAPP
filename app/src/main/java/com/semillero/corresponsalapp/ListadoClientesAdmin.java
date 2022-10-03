package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ListadoClientesAdmin extends AppCompatActivity {
    ImageView volveritem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.listado_clientes_admin );
        volveritem = findViewById(R.id.volveritem);



        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListadoClientesAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );
    }
}