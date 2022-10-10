package com.semillero.corresponsalapp.MVP.Interfaces;

import android.content.Context;

public interface interfaces {





    interface View{

        void verLogin();
        void verInicioCorresponsal();
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


        void showScreen(String screen, Object object, String typo);
    }




    interface Presenter{

    }





    interface Model{

    }






}
