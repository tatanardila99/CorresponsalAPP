package com.semillero.corresponsalapp.ViewsAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.semillero.corresponsalapp.R;

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
                TextView tvMuestraDatosCreado= findViewById(R.id.tvMuestraDatosCreado );
                Button btnSalirMuestraDatosCreado = findViewById( R.id.btnSalirMuestraDatosCreado);
                tvMuestraDatosCreado.setText("DATOS NUEVO CLIENTE");

                btnSalirMuestraDatosCreado.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ConsultarClienteAdmin.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );
            }
        } );

        cancelarConsultarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertcancel);
                Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertCancel);
                tvCancelarActcorresponsal.setText("CONSULTA CLLIENTE CANCELADA");


                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(ConsultarClienteAdmin.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );;
            }
        } );


        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarClienteAdmin.this, Inicio_administradorView.class);
                startActivity(intent);
            }
        } );


    }
}