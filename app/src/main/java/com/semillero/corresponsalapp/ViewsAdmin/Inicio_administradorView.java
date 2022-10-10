package com.semillero.corresponsalapp.ViewsAdmin;

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

import com.semillero.corresponsalapp.R;

import java.util.ArrayList;
import java.util.List;


public class Inicio_administradorView extends AppCompatActivity{


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

    }


}

