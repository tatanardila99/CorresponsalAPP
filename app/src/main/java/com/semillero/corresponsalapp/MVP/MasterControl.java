package com.semillero.corresponsalapp.MVP;

import static com.semillero.corresponsalapp.MVP.Constantes.*;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.MVP.Interfaces.Callback;
import com.semillero.corresponsalapp.MVP.Interfaces.interfaces;
import com.semillero.corresponsalapp.R;
import com.semillero.corresponsalapp.ViewsAdmin.ItemInicioAdmin;

import java.util.ArrayList;
import java.util.List;


public class MasterControl extends AppCompatActivity implements interfaces.View, Callback{


    RecyclerView recyclerViewAdmin;
    RecyclerAdminAdapter recyclerAdminAdapter;
    List<ItemInicioAdmin> items;
    List<ItemInicioAdmin> itemsCorresponsal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        showScreen( SCREEN_CORRESPONSAL, "", "" );  //DEFINE LA VISTA DE INCIO A
        iniciarValores();

    }




/*--------------------------------------------------------------------------------------------------------

                      METODOS PARA COMPORTAMIENTOS DE VISTAS Y BOTONES DE ADMINISTRADOR

-------------------------------------------------------------------------------------------------------- */



    @Override
    public void verLogin() {
        setContentView( R.layout.login_main);
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
        Button btnConfirmarCliente = findViewById( R.id.btnConfirmarCliente );

        btnConfirmarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               verConfirmarPinCliente();
            }
        } );

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
        Button btnConfirmarRegisCorresponsal = findViewById( R.id.btnConfirmarRegisCorresponsal );


        btnConfirmarRegisCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verConfirmarDatosCorresponsal();
            }
        } );

        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(SCREEN_ALERTA_CONFIRMAR, "", "" );
            }
        } );



        btnCancelarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verActualizarCorresponsales() {
        setContentView( R.layout.actualizarcorresponsal);
        Button btnCanceCorresCliente = findViewById( R.id.btnCanceCorresCliente );
        Button btnActCorresCliente = findViewById( R.id.btnActCorresCliente );

        btnActCorresCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(SCREEN_CONFIRMAR_DATOS_CORRESPONSAL, "", "" );
            }
        } );

        btnCanceCorresCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verActualizarClientes() {
        setContentView( R.layout.actualizar_clientes_admin);
        Button btnCancelarActualizarCliente = findViewById( R.id.btnCancelarActualizarCliente );
        Button btnActualizaCliente = findViewById( R.id.btnActualizaCliente );

        btnActualizaCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verConfirmarDatosCliente();
            }
        } );




        btnCancelarActualizarCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verConsultarCliente() {
        setContentView( R.layout.consultar_admin);
        Button btnCancelarConsulta = findViewById( R.id.btnCancelarConsulta );
        Button btnConfirmaDatosConsulta = findViewById( R.id.btnConfirmaDatosConsulta );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        TextInputLayout numeroConsultar = findViewById( R.id.numeroConsultar );
        numeroConsultar.setHint( "Numero de cedula a consultar" );
        tvConsultaAdmin.setText("Consultar cliente");

        btnConfirmaDatosConsulta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_PERFIL_NUEVO_CLIENTE, "", "" );
            }
        } );

        btnCancelarConsulta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verConsultarCorresponsal() {
        setContentView( R.layout.consultar_admin);
        Button btnCancelarConsulta = findViewById( R.id.btnCancelarConsulta );
        Button btnConfirmaDatosConsulta = findViewById( R.id.btnConfirmaDatosConsulta );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        TextInputLayout numeroConsultar = findViewById( R.id.numeroConsultar );
        tvConsultaAdmin.setText("Consultar corresponsal");
        numeroConsultar.setHint("Numero NIT Corresponsal");


        btnConfirmaDatosConsulta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_CONFIRMAR_DATOS_CORRESPONSAL, "", "" );
            }
        } );

        btnCancelarConsulta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );

    }

    @Override
    public void verListadoCliente() {
        setContentView( R.layout.listado_clientes_admin);

        ImageView volver = findViewById( R.id.volveritem );
        volver.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showScreen( SCREEN_ADMINISTRADOR, "", "" );

            }
        } );


    }

    @Override
    public void verListadoCorresponsal() {
        setContentView( R.layout.listado_corresponsales_admin);
        ImageView volver = findViewById( R.id.volveritem );

        volver.setOnClickListener( new View.OnClickListener() {
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
        TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
        tvAlertConfirm.setText("ACCION REALIZADA CORRECTAMENTE");

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
        TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
        tvAlertCancel.setText("ACCION CANCELADA");


        btnSalirCancelAlert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );
    }

    @Override
    public void verConfirmarDatosCorresponsal() {
        setContentView( R.layout.confirmar_datos_corresponsal);
        Button btnCancelarDatosCorresponsal = findViewById( R.id.btnCancelarDatosCorresponsal );
        Button btnConfirmaDatosCorresponsal = findViewById( R.id.btnConfirmaDatosCorresponsal );

        btnConfirmaDatosCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(SCREEN_ALERTA_CONFIRMAR, "", "" );
            }
        } );

        btnCancelarDatosCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );
    }

    @Override
    public void verConfirmarDatosCliente() {
        setContentView( R.layout.confirmar_datos_cliente);
        Button btnCancelarDatosCliente = findViewById( R.id.btnCancelarDatosCliente );
        Button btnConfirmaDatosCliente = findViewById( R.id.btnConfirmaDatosCliente );

        btnConfirmaDatosCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen(SCREEN_ALERTA_CONFIRMAR, "", "" );
            }
        } );

        btnCancelarDatosCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verConfirmarPinCliente() {
        setContentView( R.layout.confirmar_pin_cliente);

        Button btnCancelarPINCliente = findViewById( R.id.btnCancelarPINCliente );
        Button btnConfirmaPINCliente = findViewById( R.id.btnConfirmaPINCliente );

        btnConfirmaPINCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verVolverConfirmarPinCliente();
            }
        } );

        btnCancelarPINCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verVolverConfirmarPinCliente() {
        setContentView( R.layout.confirmar_pin_cliente);

        Button btnCancelarPINCliente = findViewById( R.id.btnCancelarPINCliente );
        Button btnConfirmaPINCliente = findViewById( R.id.btnConfirmaPINCliente );
        TextView textView = findViewById(R.id.tvIngresarPin );
        textView.setText( "Ingrese PIN Nuevamente" );

        btnConfirmaPINCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verPerfilNuevoCliente();
            }
        } );

        btnCancelarPINCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verPerfilNuevoCliente() {
        setContentView( R.layout.muestra_datos_cliente_creado);
        Button btnSalirMuestraDatosCreado = findViewById( R.id.btnSalirMuestraDatosCreado );

        btnSalirMuestraDatosCreado.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );
    }



    /*--------------------------------------------------------------------------------------------------------

                      METODOS PARA COMPORTAMIENTOS DE VISTAS Y BOTONES DE CORRESPONSAL

-------------------------------------------------------------------------------------------------------- */

    @Override
    public void verInicioCorresponsal() {
        setContentView( R.layout.inicio_corresponsal);
        ImageView menu = findViewById( R.id. optionsAdmin);
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );
    }










/*--------------------------------------------------------------------------------------------------------

                                 DEFINIENDO LAS VISTA DE ADMINISTRADOR

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
            case SCREEN_ADMINISTRADOR:
                verInicioAdministrador();
                break;
            case SCREEN_CREAR_CLIENTE:
                verCrearCliente();
                break;
            case SCREEN_REGISTRAR_CORRESPONSAL:
                verRegistrarCorresponsal();
                break;
            case SCREEN_CONSULTAR_CLIENTE:
                verConsultarCliente();
                break;
            case SCREEN_CONSULTAR_CORRESPONSAL:
                verConsultarCorresponsal();
                break;
            case SCREEN_ACTUALIZAR_CLIENTE:
                verActualizarClientes();
                break;
            case SCREEN_ACTUALIZAR_CORRESPONSAL:
                verActualizarCorresponsales();
                break;
            case SCREEN_LISTADO_CLIENTE:
                verListadoCliente();
                break;
            case SCREEN_LISTADO_CORRESPONSAL:
                verListadoCorresponsal();
                break;
            case SCREEN_ALERTA_CONFIRMAR:
                verAlertaConfirmar();
                break;
            case SCREEN_ALERTA_CANCELAR:
                verAlertaCancelar();
                break;
            case SCREEN_CONFIRMAR_DATOS_CORRESPONSAL:
                verConfirmarDatosCorresponsal();
                break;
            case SCREEN_CONFIRMAR_DATOS_CLIENTE:
                verConfirmarDatosCliente();
                break;
            case SCREEN_CONFIRMAR_PIN_CLIENTE:
                verConfirmarPinCliente();
                break;
            case SCREEN_VOLVER_CONFIRMAR_PIN_CLIENTE:

                break;
            case SCREEN_PERFIL_NUEVO_CLIENTE:
                verPerfilNuevoCliente();
                break;

        }
    }



/*--------------------------------------------------------------------------------------------------------

                        MENU DE OPCIONES ADMIN Y CORRESPONSAL

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

                METODO PARA INCIAR VALORES  Y AGREGAR OPCIONES DE INCIO -  ADMINISTRADOR

-------------------------------------------------------------------------------------------------------- */

    private void iniciarValores(){
        recyclerViewAdmin = findViewById(R.id.recyclerInicioAdmin );
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewAdmin.setLayoutManager(gridLayoutManager);

        items = getItems();
        RecyclerAdminAdapter recyclerAdminAdapter = new RecyclerAdminAdapter(items,this, MasterControl.this::setListener);
        recyclerViewAdmin.setAdapter(recyclerAdminAdapter);
    }

    public List<ItemInicioAdmin> getItems(){
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
    public  void setListener(  ItemInicioAdmin listenerItem) {
        switch (listenerItem.getOpcion()){
            case "crear cliente":
                verCrearCliente();
                break;
            case "Registrar corresponsal":
                verRegistrarCorresponsal();
                break;
            case "Consultar cliente":
                verConsultarCliente();
                break;
            case "Consultar corresponsal":
                verConsultarCorresponsal();
                break;
            case "Listado clientes":
                verListadoCliente();
                break;
            case "Listado corresponsales":
                verListadoCorresponsal();
                break;

        }
    }


    /*--------------------------------------------------------------------------------------------------------

                METODO PARA INCIAR VALORES  Y AGREGAR OPCIONES DE INCIO -  CORRESPONSAL

-------------------------------------------------------------------------------------------------------- */
//
//
//    private  void iniciarValoresCorresponsal(){
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
//        recyclerViewAdmin.setLayoutManager(gridLayoutManager);
//
//        itemsCorresponsal = getItems();
//       // RecyclerAdminAdapter = new RecyclerAdminAdapter(items, InicioCorresponsal.this);
//        RecyclerAdminAdapter recyclerAdminAdapterCorres = new RecyclerAdminAdapter(itemsCorresponsal,this, MasterControl.this::setListener);
//        recyclerViewAdmin.setAdapter(recyclerAdminAdapter);
//    }
//
//    private List<ItemInicioAdmin> getItems(){
//        List<ItemInicioAdmin> itemInicioAdmins = new ArrayList<>();
//        itemInicioAdmins.add(new ItemInicioAdmin("Pago con tarjeta", R.drawable.tarjeta));
//        itemInicioAdmins.add(new ItemInicioAdmin("Retiros", R.drawable.retiros));
//        itemInicioAdmins.add(new ItemInicioAdmin("Depositos", R.drawable.depositar));
//        itemInicioAdmins.add(new ItemInicioAdmin("Transferencias", R.drawable.transferencia));
//        itemInicioAdmins.add(new ItemInicioAdmin("Historial transacciones", R.drawable.historialtransacciones));
//        itemInicioAdmins.add(new ItemInicioAdmin("Consulta de saldo", R.drawable.consultasaldo));
//        return itemInicioAdmins;
//    }
//
//



}
