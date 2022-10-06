package com.semillero.corresponsalapp.ViewsAdmin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.semillero.corresponsalapp.R;

public class ConfirmarDatosCorresponsal extends AppCompatActivity {
    Button confirmaDatosCliente,cancelarDatosCliente ;
    ImageView volveritem;
    TextView nombreCorresponsalconfirmar,nitCorresponsalconfirmar, saldoCorresponsalconfirmar,correoCorresponsalconfirmar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.confirmar_datos_corresponsal);
        confirmaDatosCliente = findViewById(R.id.btnConfirmaDatosCorresponsal );
        cancelarDatosCliente = findViewById(R.id.btnCancelarDatosCorresponsal );
        volveritem = findViewById(R.id.volveritem);
        volveritem.setVisibility(View.INVISIBLE);
        nombreCorresponsalconfirmar = findViewById(R.id.nombreCorresponsalconfirmar );
        nitCorresponsalconfirmar = findViewById(R.id.numeroNITconfirmar);
        saldoCorresponsalconfirmar = findViewById(R.id.saldoCorresponsalConfirmar);
        correoCorresponsalconfirmar = findViewById(R.id.correoConfirmarCorresponsal);




        confirmaDatosCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertconfirm);
                volveritem.setVisibility(View.INVISIBLE);

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