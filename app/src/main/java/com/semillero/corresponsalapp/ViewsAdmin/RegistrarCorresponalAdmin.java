package com.semillero.corresponsalapp.ViewsAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.semillero.corresponsalapp.R;

public class RegistrarCorresponalAdmin extends AppCompatActivity {

    Button crearCorresponsal,cancelarCrearCorresponsal ;
    ImageView volveritem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.registrar_corresponal_admin );
        crearCorresponsal = findViewById(R.id.btnConfirmaDatosCliente );
        cancelarCrearCorresponsal = findViewById(R.id.btnCancelarDatosCliente );
        volveritem = findViewById(R.id.volveritem);



        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarCorresponalAdmin.this, Inicio_administradorView.class);
                startActivity(intent);
            }
        } );





        cancelarCrearCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertcancel);
                Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel);
                tvAlertCancel.setText("REGISTRO CORRESPONSAL CANCELADO");


                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(RegistrarCorresponalAdmin.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );

            }
        } );



        crearCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertconfirm);
                Button salirAlertInicio = findViewById( R.id.btnSalirAlertConfirm);
                TextView tvCancelarActCliente = findViewById( R.id.tvAlertConfirm);
                tvCancelarActCliente.setText("CORRESPONSAL REGISTRADO CORRECTAMENTE");


                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(RegistrarCorresponalAdmin.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );
            }
        } );
    }
}