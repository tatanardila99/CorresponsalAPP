package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class ConsultarCorresponsalAdmin extends AppCompatActivity {

    Button registrarCorresponsal,cancelarregistroCorresponsal;
    ImageView volveritem;
    TextView tvConsultar;
    TextInputLayout textInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.consultar_admin );
        registrarCorresponsal = findViewById(R.id.btnConfirmaDatosCliente );
        cancelarregistroCorresponsal = findViewById(R.id.btnCancelarDatosCliente );
        volveritem = findViewById(R.id.volveritem);
        tvConsultar = findViewById(R.id.tvIngresarPin );
        textInputLayout = findViewById( R.id.numeroConsultar);
        tvConsultar.setText("Consultar Corresponsal");
        textInputLayout.setHint( "Numero de NIT a consultar" );



        registrarCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.confirmar_datos_corresponsal);
                TextView tvConfirmarCorresponsal = findViewById(R.id.tvConfirmarCorresponsal );
                Button btnHabilitarCorresponsal = findViewById(R.id.btnConfirmaDatosCorresponsal );
                Button btnDesabilitarCorresponsal = findViewById(R.id.btnCancelarDatosCorresponsal );
                btnHabilitarCorresponsal.setText("Habilitar");
                btnDesabilitarCorresponsal.setText("Desabilitar");
                tvConfirmarCorresponsal.setText("Consultar Corresponsal");

                btnHabilitarCorresponsal.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                    }
                } );

                btnDesabilitarCorresponsal.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administrador.class);
                        startActivity(intent);

                    }
                } );
            }
        } );

        cancelarregistroCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );

        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );
    }
}