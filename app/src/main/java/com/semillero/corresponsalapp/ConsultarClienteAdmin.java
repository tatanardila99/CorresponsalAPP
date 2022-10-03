package com.semillero.corresponsalapp;

import static com.semillero.corresponsalapp.R.id.numerocedulaConsultar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class ConsultarClienteAdmin extends AppCompatActivity {

    Button ConsultarCliente,CancelarConsultarCliente ;
    ImageView volveritem;
    TextView tvConsultar;
    TextInputLayout textInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.consultar_admin );
        ConsultarCliente = findViewById(R.id.btnConfirmarCorresponsal);
        CancelarConsultarCliente = findViewById(R.id.btnCancelarCorresponsal);
        volveritem = findViewById(R.id.volveritem);
        tvConsultar = findViewById(R.id.tvConsultar);
        textInputLayout = findViewById(R.id.numeroConsultar);


        tvConsultar.setText("Consultar Usuario");
        textInputLayout.setHint( "Ingrese el numero de cedula" );





        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarClienteAdmin.this, Inicio_administrador.class);
                startActivity(intent);
            }
        } );


    }
}