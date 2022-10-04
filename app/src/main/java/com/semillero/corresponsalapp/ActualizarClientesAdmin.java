package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActualizarClientesAdmin extends AppCompatActivity {

    Button actualizarCliente,cancelarActualizarCliente ;
    ImageView volveritem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.actualizar_clientes_admin );
        actualizarCliente = findViewById(R.id.btnActualizaCliente );
        cancelarActualizarCliente = findViewById(R.id.btnCancelarActualizarCliente);
        volveritem = findViewById(R.id.volveritem);




        actualizarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActualizarClientesAdmin.this, ConfirmarDatosCliente.class);
                startActivity(intent);

            }
        } );

        cancelarActualizarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActualizarClientesAdmin.this, Inicio_administrador.class  );
                startActivity(intent);
            }
        } );

        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActualizarClientesAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );
    }
}