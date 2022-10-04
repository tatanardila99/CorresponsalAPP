package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ConfirmarDatosCliente extends AppCompatActivity {
    Button confirmaDatosCliente,cancelarDatosCliente ;
    ImageView volveritem;
    TextView nombreclienteconfirmar,numeroCedulaconfirmar, saldolienteconfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.confirmar_datos_cliente );
        confirmaDatosCliente = findViewById(R.id.btnConfirmaDatosCliente );
        cancelarDatosCliente = findViewById(R.id.btnCancelarDatosCliente );
        volveritem = findViewById(R.id.volveritem);
        volveritem.setVisibility(View.INVISIBLE);
        nombreclienteconfirmar = findViewById(R.id.nombreclienteconfirmar );
        numeroCedulaconfirmar = findViewById(R.id.numeroCedulaconfirmar);
        saldolienteconfirmar = findViewById(R.id.saldoConfirmarClilente);




        confirmaDatosCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.muestra_datos_cliente_creado);

            }
        } );


        cancelarDatosCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertcancel);

            }
        } );



    }
}