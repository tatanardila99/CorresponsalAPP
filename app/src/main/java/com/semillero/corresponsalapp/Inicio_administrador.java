package com.semillero.corresponsalapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.Adaptador.ItemInicioAdmin;

import java.util.ArrayList;
import java.util.List;


public class Inicio_administrador extends AppCompatActivity {

    RecyclerView  recyclerViewAdmin;
    RecyclerAdminAdapter recyclerAdminAdapter;
    List<ItemInicioAdmin> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.inicio_administrador );
        iniciarView();
        iniciarValores();

    }

    private  void iniciarView(){
        recyclerViewAdmin = findViewById(R.id.recyclerlistadoClientesAdmin );
    }

    private  void iniciarValores(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewAdmin.setLayoutManager(gridLayoutManager);

        items = getItems();
        recyclerAdminAdapter = new RecyclerAdminAdapter(items);
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


}

