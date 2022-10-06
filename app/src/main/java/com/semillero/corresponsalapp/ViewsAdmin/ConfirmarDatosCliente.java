package com.semillero.corresponsalapp.ViewsAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.semillero.corresponsalapp.R;

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
                setContentView( R.layout.alertconfirm );
                Button salirAlertInicio = findViewById( R.id.btnSalirAlertConfirm);
                TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm);
                tvAlertConfirm.setText("CLIENTE CREADO EXITOSAMENTE");

                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(ConfirmarDatosCliente.this, Inicio_administrador.class);
                        startActivity(intent);

                    }
                } );;

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