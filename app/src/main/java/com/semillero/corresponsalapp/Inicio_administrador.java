package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.Adaptador.ItemInicioAdmin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Inicio_administrador extends AppCompatActivity{


    ImageView volveritem;
    ImageView opcionIncioAdmin;
    RecyclerView  recyclerViewAdmin;
    RecyclerAdminAdapter recyclerAdminAdapter;
    List<ItemInicioAdmin> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.inicio_administrador );
        volveritem = findViewById(R.id.volveritem);
        volveritem.setVisibility(View.INVISIBLE);
        opcionIncioAdmin = findViewById(R.id.optionsAdmin);
        recyclerViewAdmin = findViewById(R.id.recyclerlistadoClientesAdmin );
        iniciarValores();

    }


      /*
     -------------------------------------------------------------------------------------------------------------------------------

                                      IMPLEMENTACION DE RECYCLER  Y  LISTA DE OPCIONES DE ADMINISTRADOR

     -------------------------------------------------------------------------------------------------------------------------------
    */

    private  void iniciarValores(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewAdmin.setLayoutManager(gridLayoutManager);

        items = getItems();
        recyclerAdminAdapter = new RecyclerAdminAdapter(items, Inicio_administrador.this);
        recyclerViewAdmin.setAdapter(recyclerAdminAdapter);
    }

    private List<ItemInicioAdmin> getItems(){
        List<ItemInicioAdmin> itemInicioAdmins = new ArrayList<>();
        itemInicioAdmins.add(new ItemInicioAdmin("crear cliente", R.drawable.newuser));
        itemInicioAdmins.add(new ItemInicioAdmin("Registrar corresponsal", R.drawable.newcorresponsal));
        itemInicioAdmins.add(new ItemInicioAdmin("Consultar cliente", R.drawable.searchusers));
        itemInicioAdmins.add(new ItemInicioAdmin("Consultar corresponsal", R.drawable.searchcorrersponsal));
        itemInicioAdmins.add(new ItemInicioAdmin("Listado clientes", R.drawable.userlist));
        itemInicioAdmins.add(new ItemInicioAdmin("Listado corresponsales", R.drawable.listcorresponsales));
        return itemInicioAdmins;
    }


    /*
     -------------------------------------------------------------------------------------------------------------------------------

                                      OPCIONES Y  METODOS  TOOLBAR  ADMINISTRADOR

     -------------------------------------------------------------------------------------------------------------------------------
    */


    public void mostrarMenu(View view) {
        ImageView imageVer = findViewById(R.id.optionsAdmin );
        PopupMenu popupMenu = new PopupMenu(this, imageVer);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actualizarCorresponsalitem:
                        actualizarCorresponsales();
                        return true;
                    case R.id.actualizarClientelitem:
                        actualizarClientes();
                        return true;
                    case R.id.cerrarsesionitem:
                        Toast.makeText(Inicio_administrador.this, " A TERMINADO SU SESION", Toast.LENGTH_SHORT).show();
                        salirSesion();
                        return true;
                }

                return false;
            }
        });
        popupMenu.show();

    }

    private void actualizarCorresponsales(){
        Intent intent = new Intent(this,  ActualizarCorresponsalAdmin.class);
        startActivity(intent);
    }

    private void actualizarClientes(){
        Intent intent = new Intent(this, ActualizarClientesAdmin.class);
        startActivity(intent);
    }

    private void salirSesion(){
        Intent intent = new Intent(this,  LoginMain.class);
        startActivity(intent);
    }


}

