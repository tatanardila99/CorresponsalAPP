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

public class Confirmar_Pin extends AppCompatActivity {

    Button confirmarPin,cancelarPin ;
    ImageView volveritem;
    TextView tvIngresarPin;
    TextInputLayout numeroPinConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.confirmar_pin_cliente );
        confirmarPin = findViewById(R.id.btnConfirmaPINCliente );
        cancelarPin = findViewById(R.id.btnCancelarPINCliente );
        tvIngresarPin = findViewById( R.id.tvIngresarPin);

        volveritem = findViewById(R.id.volveritem);
        volveritem.setVisibility(View.INVISIBLE);




        confirmarPin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.confirmar_pin_cliente );
                confirmarPin = findViewById(R.id.btnConfirmaPINCliente );
                cancelarPin = findViewById(R.id.btnCancelarPINCliente );
                tvIngresarPin = findViewById( R.id.tvIngresarPin);
                tvIngresarPin.setText("Ingresa nuevamente el PIN");
                volveritem = findViewById(R.id.volveritem);
                volveritem.setVisibility(View.INVISIBLE);

                confirmarPin.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent( Confirmar_Pin.this, ConfirmarDatosCliente.class);
                        startActivity(intent);

                    }
                } );



                cancelarPin.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent( Confirmar_Pin.this, Inicio_administrador.class);
                        startActivity(intent);
                    }
                } );

            }
        } );



        cancelarPin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Confirmar_Pin.this, Inicio_administrador.class);
                startActivity(intent);
                finish();
            }
        } );

    }
}