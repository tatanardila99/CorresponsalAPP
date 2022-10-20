package com.semillero.corresponsalapp.MVP;

import static com.semillero.corresponsalapp.MVP.Constantes.*;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputLayout;
import com.semillero.corresponsalapp.Adaptador.RecyclerAdminAdapter;
import com.semillero.corresponsalapp.MVP.Interfaces.Callback;
import com.semillero.corresponsalapp.MVP.Interfaces.interfaces;
import com.semillero.corresponsalapp.R;
import com.semillero.corresponsalapp.Views.ItemInicioAdmin;

import java.util.ArrayList;
import java.util.List;


public class MasterControl extends AppCompatActivity implements interfaces.View, Callback {


    RecyclerView recyclerViewAdmin;
    RecyclerView recyclerViewCorresponsal;
    List<ItemInicioAdmin> items;
    List<ItemInicioAdmin> itemsCorresponsal;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        showScreen( SCREEN_CORRESPONSAL, "", "" );  //DEFINE LA VISTA DE INCIO A
        iniciarValoresCorresponsal();

    }




/*--------------------------------------------------------------------------------------------------------

                      METODOS PARA COMPORTAMIENTOS DE VISTAS Y BOTONES DE ADMINISTRADOR

-------------------------------------------------------------------------------------------------------- */


    @Override
    public void verLogin() {
        setContentView( R.layout.login_main );
    }


    @Override
    public void verInicioAdministrador() {
        setContentView( R.layout.inicio_administrador );
        ImageView menu = findViewById( R.id.optionsAdmin );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );


    }

    @Override
    public void verCrearCliente() {
        setContentView( R.layout.crear_cliente );

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
        setContentView( R.layout.registrar_corresponal_admin );
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
                showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
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
        setContentView( R.layout.actualizarcorresponsal );
        Button btnCanceCorresCliente = findViewById( R.id.btnCanceCorresCliente );
        Button btnActCorresCliente = findViewById( R.id.btnActCorresCliente );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );

        btnActCorresCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_CONFIRMAR_DATOS_CORRESPONSAL, "", "" );
            }
        } );

        btnCanceCorresCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "ACTUALIZACION CORRESPONSAL CANCELADA" );

            }
        } );

    }

    @Override
    public void verActualizarClientes() {
        setContentView( R.layout.actualizar_clientes_admin );
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
        setContentView( R.layout.consultar_admin );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        TextInputLayout numeroConsultar = findViewById( R.id.numeroConsultar );
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        numeroConsultar.setHint( "Numero de cedula a consultar" );
        tvConsultaAdmin.setText( "Consultar cliente" );

        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_PERFIL_NUEVO_CLIENTE, "", "" );
            }
        } );


        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
            }
        } );

    }

    @Override
    public void verConsultarCorresponsal() {
        setContentView( R.layout.consultar_admin );
        Button btnCancelarConsulta = findViewById( R.id.btnCancelarConsulta );
        Button btnConfirmaDatosConsulta = findViewById( R.id.btnConfirmaDatosConsulta );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        TextInputLayout numeroConsultar = findViewById( R.id.numeroConsultar );
        tvConsultaAdmin.setText( "Consultar corresponsal" );
        numeroConsultar.setHint( "Numero NIT Corresponsal" );


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
        setContentView( R.layout.listado_clientes_admin );

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
        setContentView( R.layout.listado_corresponsales_admin );
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
        setContentView( R.layout.alertconfirm );
        Button btnSalirAlertConfirm = findViewById( R.id.btnSalirAlertConfirm );

        btnSalirAlertConfirm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );

    }

    @Override
    public void verAlertaCancelar() {
        setContentView( R.layout.alertcancel );
        Button btnSalirCancelAlert = findViewById( R.id.btnSalirCancelAlert );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility(View.GONE );

        btnSalirCancelAlert.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ADMINISTRADOR, "", "" );
            }
        } );
    }

    @Override
    public void verConfirmarDatosCorresponsal() {
        setContentView( R.layout.confirmar_datos_corresponsal );
        Button btnCancelarDatosCorresponsal = findViewById( R.id.btnCancelarDatosCorresponsal );
        Button btnConfirmaDatosCorresponsal = findViewById( R.id.btnConfirmaDatosCorresponsal );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );

        btnConfirmaDatosCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                tvAlertConfirm.setText( "CORRESPONSAL ACTUALIZADO CORRECTAMENTE" );
            }
        } );

        btnCancelarDatosCorresponsal.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "ACTUALIZCION CORRESPONSAL CANCELADA" );

            }
        } );
    }

    @Override
    public void verConfirmarDatosCliente() {
        setContentView( R.layout.confirmar_datos_cliente );
        Button btnCancelarDatosCliente = findViewById( R.id.btnCancelarDatosCliente );
        Button btnConfirmaDatosCliente = findViewById( R.id.btnConfirmaDatosCliente );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );


        btnConfirmaDatosCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                ImageView volver = findViewById( R.id.volveritem);
                volver.setVisibility( View.GONE );
                tvAlertConfirm.setText( "CLIENTE CREADO CORRECTAMENTE" );
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
        setContentView( R.layout.confirmar_pin_cliente );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );

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
        setContentView( R.layout.confirmar_pin_cliente );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );

        Button btnCancelarPINCliente = findViewById( R.id.btnCancelarPINCliente );
        Button btnConfirmaPINCliente = findViewById( R.id.btnConfirmaPINCliente );
        TextView textView = findViewById( R.id.tvIngresarPin );
        textView.setText( "Ingrese PIN Nuevamente" );

        btnConfirmaPINCliente.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verConfirmarDatosCliente();
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
        setContentView( R.layout.muestra_datos_cliente_creado );
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
        setContentView( R.layout.inicio_corresponsal );
        ImageView volver = findViewById( R.id.volveritem );
        ImageView imgReutiilizarCorresponsal = findViewById( R.id.imgReutiilizarCorres);
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        Button cancelar = findViewById( R.id.btnCancelarReutilizar );
        Button confirmar = findViewById( R.id.btnConfirmarReutilizar );
        volver.setVisibility( View.GONE );
        imgReutiilizarCorresponsal.setVisibility( View.GONE );
        tvReutiilizarCorresponsal.setVisibility( View.GONE );
        cancelar.setVisibility( View.GONE );
        confirmar.setVisibility( View.GONE );

    }

    @Override
    public void verPagosTarjeta() {
        setContentView( R.layout.pago_tarjeta);
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        ImageView menu = findViewById( R.id.optionsAdmin );
        menu.setVisibility( View.GONE );
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        tvReutiilizarCorresponsal.setText( "Pago con tarjeta" );

        String[] cuotas = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> cuotasAdapter = new ArrayAdapter<>( this, R.layout.list_item_cuotas_corresponsal, cuotas);
        AutoCompleteTextView autoCompleteTextView = findViewById( R.id.spinner);
        autoCompleteTextView.setAdapter(cuotasAdapter);



        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    verConfirmarPagosTarjeta();
            }
        } );

        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
            }
        } );


    }

    @Override
    public void verConfirmarPagosTarjeta() {
        setContentView( R.layout.confirmar_pago_tarjeta);
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        TextView tvNombreCorresponsal = findViewById( R.id.tvNombreCorresponsal );
        TextView tvSaldoCorresponsal = findViewById( R.id.tvSaldoCorresponsal );
        TextView tvCuentaCorresponsal = findViewById( R.id.tvCuentaCorresponsal );
        ImageView menu = findViewById( R.id.optionsAdmin );
        ImageView volver = findViewById( R.id.volveritem );
        tvNombreCorresponsal.setVisibility( View.GONE );
        tvSaldoCorresponsal.setVisibility( View.GONE );
        tvCuentaCorresponsal.setVisibility( View.GONE );
        menu.setVisibility( View.GONE );
        volver.setVisibility( View.GONE );
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        tvReutiilizarCorresponsal.setText( "Confirmacion Pago" );

        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView( R.layout.confirmar_pin_cliente );
                TextView tvIngresarPin = findViewById( R.id.tvIngresarPin );
                tvIngresarPin.setText( "Confirmar PIN" );
                verConfirmarPinPagosTarjeta();
            }
        } );

        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                ImageView volver = findViewById( R.id.volveritem);
                volver.setVisibility( View.GONE );
                tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
            }
        } );





    }

    @Override
    public void verConfirmarPinPagosTarjeta() {
        Button btnCancelarPinPago = findViewById( R.id.btnCancelarPINCliente );
        Button btnConfirmaPinPago = findViewById( R.id.btnConfirmaPINCliente );
        ImageView volver = findViewById( R.id.volveritem );
        volver.setVisibility( View.GONE );

        btnConfirmaPinPago.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                ImageView volver = findViewById( R.id.volveritem );
                TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                volver.setVisibility( View.GONE );
                tvAlertConfirm.setText( "PAGO REALIZADO CORRECTAMENTE" );

            }
        } );

        btnCancelarPinPago.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                volver.setVisibility( View.GONE );
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
            }
        } );

    }

    @Override
    public void verRetiros() {
        setContentView( R.layout.retiros );

        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
        ImageView optionsAdmin = findViewById( R.id.optionsAdmin );
        optionsAdmin.setVisibility( View.GONE );
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        tvReutiilizarCorresponsal.setText( "RETIROS" );;

        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog( MasterControl.this );
                Button btnSi,btnNo;
                dialog.setContentView( R.layout.dialog );
                btnSi =  dialog.findViewById( R.id.btnSI );
                btnNo =  dialog.findViewById( R.id.btnNO );

                btnSi.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_CONFIRMAR_RETIROS, "", "" );
                        dialog.dismiss();
                    }
                } );

                btnNo.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                        TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                        tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
                        dialog.dismiss();
                    }
                } );

                dialog.show();

            }
        } );


        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                optionsAdmin.setVisibility( View.GONE );
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "RETIRO CANCELADO CORRECTAMENTE" );
            }
        } );


    }



    @Override
    public void verConfirmarRetiros() {
        setContentView( R.layout.confirmar_retiro );
        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        ImageView optionsAdmin = findViewById( R.id.optionsAdmin );
        ImageView volveritem = findViewById( R.id.volveritem );
        optionsAdmin.setVisibility( View.GONE );
        volveritem.setVisibility( View.GONE );
        tvReutiilizarCorresponsal.setText( "Confirmar retiro" );

        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                tvAlertConfirm.setText( "RETIRO REALIZADO CORRECTAMENTE" );
            }
        } );

        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
            }
        } );
    }



    @Override
    public void verDepositos() {
        setContentView( R.layout.deposito );
        ImageView menu = findViewById( R.id.optionsAdmin );
        menu.setVisibility( View.GONE );
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        tvReutiilizarCorresponsal.setText( "Deposito" );
        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );


        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_CONFIRMAR_RETIROS, "", "" );
                Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
                Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
                TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
                ImageView optionsAdmin = findViewById( R.id.optionsAdmin );
                ImageView volveritem = findViewById( R.id.volveritem );
                optionsAdmin.setVisibility( View.GONE );
                volveritem.setVisibility( View.GONE );
                tvReutiilizarCorresponsal.setText( "Confirmar deposito" );

                btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                        TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                        tvAlertConfirm.setText( "DEPOSITO REALIZADO CORRECTAMENTE" );
                    }
                } );

                btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                        TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                        tvAlertCancel.setText( "DEPOSITO CANCELADO CORRECTAMENTE" );
                    }
                } );

            }
        } );

        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "DEPOSITO CANCELADO" );
            }
        } );
    }



    @Override
    public void verTransferecias() {

        setContentView( R.layout.deposito );
        ImageView menu = findViewById( R.id.optionsAdmin );
        menu.setVisibility( View.GONE );
        TextView tvReutiilizarCorresponsal = findViewById( R.id.tvReutiilizarCorresponsal );
        tvReutiilizarCorresponsal.setText( "Transferencia" );
        Button btnCancelarReutilizar = findViewById( R.id.btnCancelarReutilizar );
        Button btnConfirmarReutilizar = findViewById( R.id.btnConfirmarReutilizar );
        TextInputLayout numeroPinConfirmar = findViewById( R.id.numeroPinConfirmar );
        TextInputLayout numeroP = findViewById( R.id.numeroP );
        TextInputLayout numerorgeP = findViewById( R.id.numerorgeP );
        numeroPinConfirmar.setHint( "Numero de cedula a transferir" );
        numeroP.setHint( "Numero de cedula que transfiere" );
        numerorgeP.setHint( "Monto a transferir" );


        btnConfirmarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_CONFIRMAR_PIN_CLIENTE, "", "" );
                Button btnCancelarPINCliente = findViewById( R.id.btnCancelarPINCliente );
                Button btnConfirmaPINCliente = findViewById( R.id.btnConfirmaPINCliente );
                ImageView volveritem = findViewById( R.id.volveritem );
                volveritem.setVisibility( View.GONE );



                btnConfirmaPINCliente.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                        TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                        tvAlertConfirm.setText( "TRANSFERENCIA REALIZADA CORRECTAMENTE" );
                    }
                } );

                btnCancelarPINCliente.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                        TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                        tvAlertCancel.setText( "TRANSFERECNIA CANCELADA CORRECTAMENTE" );
                    }
                } );

            }
        } );

        btnCancelarReutilizar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "DEPOSITO CANCELADO" );
            }
        } );

    }

    @Override
    public void verHistorialTransaccional() {

    }

    @Override
    public void verConsultaSaldo() {
        setContentView( R.layout.consultar_admin );
        Button btnCancelarConsulta = findViewById( R.id.btnCancelarConsulta );
        Button btnConfirmaDatosConsulta = findViewById( R.id.btnConfirmaDatosConsulta );
        TextInputLayout numeroConsultar = findViewById( R.id.numeroConsultar );
        TextView tvConsultaAdmin = findViewById( R.id.tvConsultaAdmin );
        ImageView volveritem = findViewById( R.id.volveritem );
        volveritem.setVisibility( View.GONE );
        tvConsultaAdmin.setText( "Consulta de saldo" );
        numeroConsultar.setHint( "Numero de cedula a consultar" );



        btnConfirmaDatosConsulta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_CONFIRMAR_PIN_CLIENTE, "", "" );
                Button btnCancelarPINCliente = findViewById( R.id.btnCancelarPINCliente );
                Button btnConfirmaPINCliente = findViewById( R.id.btnConfirmaPINCliente );
                ImageView volveritem = findViewById( R.id.volveritem );
                volveritem.setVisibility( View.GONE );

                btnCancelarPINCliente.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                        TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                        tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
                    }
                } );

                btnConfirmaPINCliente.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Dialog dialog = new Dialog( MasterControl.this );
                        Button btnSi,btnNo;
                        TextView textdialogo;
                        dialog.setContentView( R.layout.dialog );
                        btnSi =  dialog.findViewById( R.id.btnSI );
                        btnNo =  dialog.findViewById( R.id.btnNO );
                        textdialogo = dialog.findViewById( R.id.textdialogo );
                        textdialogo.setText( "Consultar saldo tiene un costo de 1.000.00 pesos que se descintaran directamente de su cuenta WPOSS. Desea continuar?");


                        btnSi.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                setContentView( R.layout.result_consultar_saldo);
                                dialog.dismiss();
                                verResultadoConsultaSaldo();
                            }
                        } );

                        btnNo.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                                tvAlertCancel.setText( "PAGO CANCELADO CORRECTAMENTE" );
                                dialog.dismiss();
                            }
                        } );

                        dialog.show();

                    }
                } );

            }
        } );

        btnCancelarConsulta.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CANCELAR, "", "" );
                TextView tvAlertCancel = findViewById( R.id.tvAlertCancel );
                tvAlertCancel.setText( "CONSULTA DE SALDO CANCELADA" );
            }
        } );

    }

    @Override
    public void verResultadoConsultaSaldo() {
        Button aceptarResultadoSaldo = findViewById( R.id.btnSalirConsultaSaldo );
        aceptarResultadoSaldo.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScreen( SCREEN_ALERTA_CONFIRMAR, "", "" );
                TextView tvAlertConfirm = findViewById( R.id.tvAlertConfirm );
                tvAlertConfirm.setText( "CONSULTA REALIZADA CORRECTAMENTE" );;
            }
        } );

    }

/*--------------------------------------------------------------------------------------------------------

                                      DEFINIENDO LAS VISTA

-------------------------------------------------------------------------------------------------------- */


    @Override
    public void showScreen(String screen, Object object, String typo) {
        switch (screen) {
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
                verVolverConfirmarPinCliente();
                break;
            case SCREEN_PERFIL_NUEVO_CLIENTE:
                verPerfilNuevoCliente();
                break;
            case SCREEN_PAGOS_TARJETA:
                verPagosTarjeta();
                break;
            case SCREEN_CONFIRMAR_PAGOS_TARJETA:
                verConfirmarPagosTarjeta();
                break;
            case SCREEN_CONFIRMAR_PIN_PAGOS_TARJETA:
                verConfirmarPinPagosTarjeta();
                break;
            case SCREEN_RETIROS:
                verRetiros();
                break;
            case SCREEN_DEPOSITOS:
                verDepositos();
                break;
            case SCREEN_TRASNFERENCIAS:
                verTransferecias();
                break;
            case SCREEN_HISTORIAL_TRANSACCIONAL:
                verHistorialTransaccional();
                break;
            case SCREEN_CONSULTA_SALDO:
                verConsultaSaldo();
                break;
            case SCREEN_CONFIRMAR_RETIROS:
                verConfirmarRetiros();
                break;
            case SCREEN_RESULTADO_CONSULTA_SALDO:
                verResultadoConsultaSaldo();
                break;

        }
    }



/*--------------------------------------------------------------------------------------------------------

                        MENU DE OPCIONES ADMIN Y CORRESPONSAL

-------------------------------------------------------------------------------------------------------- */

    public void mostrarMenuCorresponsal(View view) {
        ImageView imageVer = findViewById( R.id.optionsAdmin );
        PopupMenu popupMenu = new PopupMenu( this, imageVer );
        popupMenu.getMenuInflater().inflate( R.menu.menucorresponsal, popupMenu.getMenu() );

        popupMenu.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actualizarDatositem:
                        showScreen( SCREEN_ACTUALIZAR_CORRESPONSAL, "", "" );
                        return true;
                    case R.id.crearClientelitem:
                        showScreen( SCREEN_CREAR_CLIENTE, "", "" );
                        return true;
                    case R.id.cerrarsesionitem2:
                        showScreen( SCREEN_LOGIN, "", "" );
                        return true;
                }

                return false;
            }
        } );
        popupMenu.show();

    }


    public void mostrarMenuAdministrador(View view) {
        ImageView imageVer = findViewById( R.id.optionsAdmin );
        PopupMenu popupMenu = new PopupMenu( this, imageVer );
        popupMenu.getMenuInflater().inflate( R.menu.menu, popupMenu.getMenu() );

        popupMenu.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.actualizarCorresponsalitem:
                        showScreen( SCREEN_ACTUALIZAR_CORRESPONSAL, "", "" );
                        return true;
                    case R.id.actualizarClientelitem:
                        showScreen( SCREEN_ACTUALIZAR_CLIENTE, "", "" );
                        return true;
                    case R.id.cerrarsesionitem:
                        showScreen( SCREEN_LOGIN, "", "" );

                        return true;
                }

                return false;
            }
        } );
        popupMenu.show();

    }


/*--------------------------------------------------------------------------------------------------------

                METODO PARA INCIAR VALORES  Y AGREGAR OPCIONES DE INCIO -  ADMINISTRADOR

-------------------------------------------------------------------------------------------------------- */

    private void iniciarValores() {
        recyclerViewAdmin = findViewById( R.id.recyclerInicioAdmin );
        GridLayoutManager gridLayoutManager = new GridLayoutManager( this, 2 );
        recyclerViewAdmin.setLayoutManager( gridLayoutManager );

        items = getItems();
        RecyclerAdminAdapter recyclerAdminAdapter = new RecyclerAdminAdapter( items, this, MasterControl.this::setListener);
        recyclerViewAdmin.setAdapter( recyclerAdminAdapter );
    }

    public List<ItemInicioAdmin> getItems() {
        List<ItemInicioAdmin> itemInicioAdmins = new ArrayList<>();
        itemInicioAdmins.add( new ItemInicioAdmin( "crear cliente", R.drawable.newuser ) );
        itemInicioAdmins.add( new ItemInicioAdmin( "Registrar corresponsal", R.drawable.newcorresponsal ) );
        itemInicioAdmins.add( new ItemInicioAdmin( "Consultar cliente", R.drawable.searchusers ) );
        itemInicioAdmins.add( new ItemInicioAdmin( "Consultar corresponsal", R.drawable.searchcorrersponsal ) );
        itemInicioAdmins.add( new ItemInicioAdmin( "Listado clientes", R.drawable.userlist ) );
        itemInicioAdmins.add( new ItemInicioAdmin( "Listado corresponsales", R.drawable.listcorresponsales ) );
        return itemInicioAdmins;
    }


    @Override
    public void setListener(ItemInicioAdmin listenerItem) {
        switch (listenerItem.getOpcion()) {
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
            case "Pago con tarjeta":
                    verPagosTarjeta();
                break;
            case "Retiros":
                    verRetiros();
                break;
            case "Depositos":
                    verDepositos();
                break;
            case "Transferencias":
                    verTransferecias();
                break;
            case "Historial transacciones":
                    verHistorialTransaccional();
            break;
            case "Consulta de saldo":
                    verConsultaSaldo();
            break;

        }

    }






/*--------------------------------------------------------------------------------------------------------

                METODO PARA INCIAR VALORES  Y AGREGAR OPCIONES DE INCIO -  CORRESPONSAL

-------------------------------------------------------------------------------------------------------- */


    private  void iniciarValoresCorresponsal(){
        recyclerViewCorresponsal = findViewById( R.id.recyclerViewCorresponsal );
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewCorresponsal.setLayoutManager(gridLayoutManager);

        itemsCorresponsal = getItemsCorresponsal();
        RecyclerAdminAdapter recyclerAdminAdapterCorres = new RecyclerAdminAdapter(itemsCorresponsal,this, MasterControl.this::setListener);
        recyclerViewCorresponsal.setAdapter(recyclerAdminAdapterCorres);
    }

    private List<ItemInicioAdmin> getItemsCorresponsal(){
        List<ItemInicioAdmin> itemInicioCorresponsal = new ArrayList<>();
        itemInicioCorresponsal.add(new ItemInicioAdmin("Pago con tarjeta", R.drawable.tarjeta));
        itemInicioCorresponsal.add(new ItemInicioAdmin("Retiros", R.drawable.retiros));
        itemInicioCorresponsal.add(new ItemInicioAdmin("Depositos", R.drawable.depositar));
        itemInicioCorresponsal.add(new ItemInicioAdmin("Transferencias", R.drawable.transferencia));
        itemInicioCorresponsal.add(new ItemInicioAdmin("Historial transacciones", R.drawable.historialtransacciones));
        itemInicioCorresponsal.add(new ItemInicioAdmin("Consulta de saldo", R.drawable.consultasaldo));
        return itemInicioCorresponsal;
    }


}
