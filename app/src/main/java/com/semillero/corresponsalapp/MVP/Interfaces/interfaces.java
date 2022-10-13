package com.semillero.corresponsalapp.MVP.Interfaces;

import android.content.Context;

public interface interfaces {

    interface View{

        void verLogin();
        void verInicioAdministrador();
        void verCrearCliente();
        void verRegistrarCorresponsal();
        void verActualizarCorresponsales();
        void verActualizarClientes();
        void verConsultarCliente();
        void verConsultarCorresponsal();
        void verListadoCliente();
        void verListadoCorresponsal();
        void verAlertaConfirmar();
        void verAlertaCancelar();
        void verConfirmarDatosCorresponsal();
        void verConfirmarDatosCliente();
        void verConfirmarPinCliente();
        void verVolverConfirmarPinCliente();
        void verPerfilNuevoCliente();

        void verInicioCorresponsal();
        void verPagosTarjeta();
        void verConfirmarPagosTarjeta();
        void verConfirmarPinPagosTarjeta();
        void verRetiros();
        void verConfirmarRetiros();
        void verDepositos();
        void verTransferecias();
        void verHistorialTransaccional();
        void verConsultaSaldo();
        void verResultadoConsultaSaldo();


        void showScreen(String screen, Object object, String typo);

    }




    interface Presenter{

    }





    interface Model{

    }






}
