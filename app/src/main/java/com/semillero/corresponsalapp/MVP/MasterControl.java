package com.semillero.corresponsalapp.MVP;

import static com.semillero.corresponsalapp.MVP.Constantes.*;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.MVP.Interfaces.Callback;
import com.semillero.corresponsalapp.MVP.Interfaces.interfaces;
import com.semillero.corresponsalapp.R;
import com.semillero.corresponsalapp.ViewsAdmin.Inicio_administradorView;
import com.semillero.corresponsalapp.ViewsAdmin.ItemInicioAdmin;
import com.semillero.corresponsalapp.ViewsCorresponsal.InicioCorresponsal;

import java.util.ArrayList;
import java.util.List;


public class MasterControl extends AppCompatActivity implements interfaces.View , Callback {


    RecyclerView recyclerViewAdmin;
    RecyclerAdminAdapter recyclerAdminAdapter;
    List<ItemInicioAdmin> items;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        showScreen( SCREEN_ADMINISTRADOR, "", "" );
        iniciarValores();

    }



    @Override
    public void verLogin() {
        setContentView( R.layout.login_main);
    }


    @Override
    public void verInicioCorresponsal() {
        setContentView( R.layout.inicio_corresponsal);
        ImageView menu = findViewById( R.id. optionsAdmin);
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );
    }

    @Override
    public void verInicioAdministrador() {
        setContentView( R.layout.inicio_administrador);
        ImageView menu = findViewById( R.id. optionsAdmin);
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );


    }


    @Override
    public void verCrearCliente() {
        setContentView( R.layout.crear_cliente);
        Button btnCancelarCliente = findViewById( R.id.btnCancelarCliente );
        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );


    }



    @Override
    public void verRegistrarCorresponsal() {
        setContentView( R.layout.registrar_corresponal_admin);
        Button btnCancelarCliente = findViewById( R.id.btnCancelarCorresponsal );
        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );

    }

    @Override
    public void verActualizarCorresponsales() {
        setContentView( R.layout.actualizarcorresponsal);
        Button btnCancelarCliente = findViewById( R.id.btnCanceCorresCliente );
        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verActualizarClientes() {
        setContentView( R.layout.actualizar_clientes_admin);
        Button btnCancelarActualizarCliente = findViewById( R.id.btnCancelarActualizarCliente );
        btnCancelarActualizarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verConsultarCliente() {
        setContentView( R.layout.actualizar_clientes_admin);
        Button btnCancelarCliente = findViewById( R.id.btnCancelarActualizarCliente );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        tvConsultaAdmin.setText("Consultar cliente");

        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verConsultarCorresponsal() {
        setContentView( R.layout.consultar_admin);
        Button btnCancelarCliente = findViewById( R.id.btnCancelarConsulta );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        tvConsultaAdmin.setText("Consultar cliente");

        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );

    }

    @Override
    public void verListadoCliente() {
        setContentView( R.layout.listado_clientes_admin);
        Button btnCancelarCliente = findViewById( R.id.btnCancelarConsulta );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        tvConsultaAdmin.setText("Consultar cliente");

        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );


    }

    @Override
    public void verListadoCorresponsal() {
        setContentView( R.layout.listado_corresponsales_admin);
        Button btnCancelarCliente = findViewById( R.id.btnCancelarConsulta );

        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );


    }




    @Override
    public void verAlertaConfirmar() {
        setContentView( R.layout.alertconfirm);
        Button btnCancelarCliente = findViewById( R.id.btnSalirAlertConfirm );

        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );

    }




    @Override
    public void verAlertaCancelar() {
        setContentView( R.layout.alertcancel);
        Button btnSalirCancelAlert = findViewById( R.id.btnSalirCancelAlert );

        btnSalirCancelAlert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );
    }



/*--------------------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------------------- */
    @Override
    public void showScreen(String screen, Object object, String typo) {
        switch (screen){
            case SCREEN_LOGIN:
                verLogin();
                break;
            case SCREEN_CORRESPONSAL:
                verInicioCorresponsal();
                break;
            case SCREEN_CREAR_CLIENTE:
                verCrearCliente();
                break;
            case SCREEN_REGISTRAR_CORRESPONSAL:
                verRegistrarCorresponsal();
                break;
            case SCREEN_ADMINISTRADOR:
                verInicioAdministrador();
                break;
            case SCREEN_ALERTA_CONFIRMAR:
                verAlertaConfirmar();
                break;
            case SCREEN_ALERTA_CANCELAR:
                verAlertaCancelar();
                break;
            case SCREEN_ACTUALIZAR_CORRESPONSAL:
                verActualizarCorresponsales();

                break;
            case SCREEN_ACTUALIZAR_CLIENTE:
                verActualizarClientes();
                break;

        }
    }




/*--------------------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------------------- */

    public void mostrarMenuCorresponsal(View view) {
        ImageView imageVer = findViewById(R.id.optionsAdmin );
        PopupMenu popupMenu = new PopupMenu(this, imageVer);
        popupMenu.getMenuInflater().inflate(R.menu.menucorresponsal, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actualizarDatositem:
                        showScreen( SCREEN_REGISTRAR_CORRESPONSAL, "", "" );
                        return true;
                    case R.id.crearClientelitem:
                        showScreen( SCREEN_CREAR_CLIENTE, "", "" );
                        return true;
                    case R.id.cerrarsesionitem2:
                        showScreen( SCREEN_LOGIN,"","" );
                        return true;
                }

                return false;
            }
        });
        popupMenu.show();

    }



    public void mostrarMenuAdministrador(View view) {
        ImageView imageVer = findViewById(R.id.optionsAdmin );
        PopupMenu popupMenu = new PopupMenu(this, imageVer);
        popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actualizarCorresponsalitem:
                        showScreen(SCREEN_ACTUALIZAR_CORRESPONSAL,"","" );
                        return true;
                    case R.id.actualizarClientelitem:
                        showScreen(SCREEN_ACTUALIZAR_CLIENTE,"","" );
                        return true;
                    case R.id.cerrarsesionitem:
                        showScreen( SCREEN_LOGIN ,"","" );

                        return true;
                }

                return false;
            }
        });
        popupMenu.show();

    }







/*--------------------------------------------------------------------------------------------------------



-------------------------------------------------------------------------------------------------------- */

    private void iniciarValores(){
        recyclerViewAdmin = findViewById(R.id.recyclerInicioAdmin );
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewAdmin.setLayoutManager(gridLayoutManager);

        items = getItems();
        RecyclerAdminAdapter recyclerAdminAdapter = new RecyclerAdminAdapter(items,this, MasterControl.this);
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


    @Override
    public void onclick() {
       //switch (id){
//            case SCREEN_ACTUALIZAR_CLIENTE:
//                verActualizarClientes();
//                break;
        //}
    }
}
