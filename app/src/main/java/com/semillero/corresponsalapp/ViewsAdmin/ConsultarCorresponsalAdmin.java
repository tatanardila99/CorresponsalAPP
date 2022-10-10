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
                        setContentView( R.layout.alertconfirm);
                        Button salirAlertInicio = findViewById( R.id.btnSalirAlertConfirm);
                        TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertConfirm);
                        tvCancelarActcorresponsal.setText("CORRESPONSAL HABILITADO");


                        salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administradorView.class);
                                startActivity(intent);
                            }
                        } );;

                    }
                } );

                btnDesabilitarCorresponsal.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView( R.layout.alertcancel);
                        Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                        TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertCancel);
                        tvCancelarActcorresponsal.setText("CORRESPONSAL DESABILITADO");


                        salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administradorView.class);
                                startActivity(intent);
                            }
                        } );;

                    }
                } );
            }
        } );

        cancelarregistroCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertcancel);
                Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertCancel);
                tvCancelarActcorresponsal.setText("CONSULTA CORRESPONSAL CANCELADA");


                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );;
            }
        } );

        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConsultarCorresponsalAdmin.this, Inicio_administradorView.class);
                startActivity(intent);
            }
        } );
    }
}