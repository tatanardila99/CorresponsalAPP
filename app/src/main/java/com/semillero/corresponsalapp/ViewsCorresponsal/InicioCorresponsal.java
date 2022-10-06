package com.semillero.corresponsalapp.ViewsCorresponsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.R;
import com.semillero.corresponsalapp.ViewsAdmin.ActualizarCorresponsalAdmin;
import com.semillero.corresponsalapp.ViewsAdmin.CrearClienteAdmin;
import com.semillero.corresponsalapp.ViewsAdmin.Inicio_administrador;
import com.semillero.corresponsalapp.ViewsAdmin.ItemInicioAdmin;
import com.semillero.corresponsalapp.ViewsAdmin.LoginMain;
import com.semillero.corresponsalapp.ViewsAdmin.RegistrarCorresponalAdmin;

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


    public void mostrarMenuCorresponsal(View view) {
        ImageView imageVer = findViewById(R.id.optionsAdmin );
        PopupMenu popupMenu = new PopupMenu(this, imageVer);
        popupMenu.getMenuInflater().inflate(R.menu.menucorresponsal, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actualizarDatositem:

                        //actualizarDatos();
                        return true;
                    case R.id.crearClientelitem:
                        //crearClientes();
                        return true;
                    case R.id.cerrarsesionitem2:
                        Toast.makeText(InicioCorresponsal.this, " A TERMINADO SU SESION", Toast.LENGTH_SHORT).show();
                        //salirSesionCorresponsal();
                        return true;
                }

                return false;
            }
        });
        popupMenu.show();

    }

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
                Intent intent = new Intent(InicioCorresponsal.this, Inicio_administrador.class);
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
                        Intent intent = new Intent(InicioCorresponsal.this, Inicio_administrador.class);
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
                                Intent intent = new Intent(InicioCorresponsal.this, Inicio_administrador.class);
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

                                Intent intent = new Intent(InicioCorresponsal.this, Inicio_administrador.class);
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

                        Intent intent = new Intent(InicioCorresponsal.this, Inicio_administrador.class);
                        startActivity(intent);
                    }
                } );

            }
        } );







    }


}