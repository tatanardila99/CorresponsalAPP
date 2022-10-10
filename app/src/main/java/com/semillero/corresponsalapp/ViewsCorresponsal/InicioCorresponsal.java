package com.semillero.corresponsalapp.ViewsCorresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.R;
import com.semillero.corresponsalapp.ViewsAdmin.Inicio_administradorView;
import com.semillero.corresponsalapp.ViewsAdmin.ItemInicioAdmin;

import java.util.ArrayList;
import java.util.List;

public class InicioCorresponsal extends AppCompatActivity  {

    ImageView volveritem;
    ImageView opcionIncioAdmin;
    RecyclerView recyclerViewAdmin;
    RecyclerAdminAdapter recyclerAdminAdapter;
    List<ItemInicioAdmin> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.inicio_corresponsal );
        volveritem = findViewById(R.id.volveritem);
        volveritem.setVisibility( View.INVISIBLE);
        opcionIncioAdmin = findViewById(R.id.optionsAdmin);
        recyclerViewAdmin = findViewById(R.id.recyclerlistadoClientesAdmin );
        iniciarValores();

    }


      /*
     -------------------------------------------------------------------------------------------------------------------------------

                                      IMPLEMENTACION DE RECYCLER  Y  LISTA DE OPCIONES DE CORRESPONSAL

     -------------------------------------------------------------------------------------------------------------------------------
    */

    private  void iniciarValores(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewAdmin.setLayoutManager(gridLayoutManager);

        items = getItems();
        recyclerAdminAdapter = new RecyclerAdminAdapter(items, InicioCorresponsal.this);
        recyclerViewAdmin.setAdapter(recyclerAdminAdapter);
    }

    private List<ItemInicioAdmin> getItems(){
        List<ItemInicioAdmin> itemInicioAdmins = new ArrayList<>();
        itemInicioAdmins.add(new ItemInicioAdmin("Pago con tarjeta", R.drawable.tarjeta));
        itemInicioAdmins.add(new ItemInicioAdmin("Retiros", R.drawable.retiros));
        itemInicioAdmins.add(new ItemInicioAdmin("Depositos", R.drawable.depositar));
        itemInicioAdmins.add(new ItemInicioAdmin("Transferencias", R.drawable.transferencia));
        itemInicioAdmins.add(new ItemInicioAdmin("Historial transacciones", R.drawable.historialtransacciones));
        itemInicioAdmins.add(new ItemInicioAdmin("Consulta de saldo", R.drawable.consultasaldo));
        return itemInicioAdmins;
    }


    /*
     -------------------------------------------------------------------------------------------------------------------------------

                                      OPCIONES Y  METODOS  TOOLBAR  CORRESPONSAL

     -------------------------------------------------------------------------------------------------------------------------------
    */




    private void actualizarDatos(){
        setContentView( R.layout.actualizarcorresponsal );
        Button actualizarCorresponsal,CancelaractualizarCorresponsal;
        ImageView volveritem;
        actualizarCorresponsal = findViewById(R.id.btnActCorresCliente );
        CancelaractualizarCorresponsal = findViewById(R.id.btnCanceCorresCliente );
        volveritem = findViewById(R.id.volveritem);


        volveritem.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InicioCorresponsal.this, Inicio_administradorView.class);
                startActivity(intent);
            }
        } );


        actualizarCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.confirmar_datos_corresponsal );
                Button btnConfirmaDatosCorresponsal = findViewById(R.id.btnConfirmaDatosCorresponsal );
                Button CancelaractualizarCorresponsal = findViewById(R.id.btnCancelarDatosCorresponsal );
                ImageView volveritem = findViewById(R.id.volveritem);

                volveritem.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(InicioCorresponsal.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );



                btnConfirmaDatosCorresponsal.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView(R.layout.alertconfirm);
                        Button salirAlertInicio = findViewById( R.id.btnSalirAlertConfirm);
                        TextView tvActcorresponsal = findViewById( R.id.tvAlertConfirm);
                        tvActcorresponsal.setText("ACTUALIZACION CORRESPONSAL CORRECTA");


                        salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(InicioCorresponsal.this, Inicio_administradorView.class);
                                startActivity(intent);
                            }
                        } );

                    }
                } );



                CancelaractualizarCorresponsal.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setContentView( R.layout.alertcancel);
                        Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                        TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertCancel);
                        tvCancelarActcorresponsal.setText("ACTUALIZACION CORRESPONSAL CANCELADA");


                        salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(InicioCorresponsal.this, Inicio_administradorView.class);
                                startActivity(intent);
                            }
                        } );

                    }
                } );



            }
        } );

        CancelaractualizarCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.alertcancel);
                Button salirAlertInicio = findViewById( R.id.btnSalirCancelAlert);
                TextView tvCancelarActcorresponsal = findViewById( R.id.tvAlertCancel);
                tvCancelarActcorresponsal.setText("ACTUALIZACION CORRESPONSAL CANCELADA");


                salirAlertInicio.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(InicioCorresponsal.this, Inicio_administradorView.class);
                        startActivity(intent);
                    }
                } );

            }
        } );







    }


}