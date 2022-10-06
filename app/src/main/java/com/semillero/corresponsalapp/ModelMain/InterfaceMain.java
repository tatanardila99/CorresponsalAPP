package com.semillero.corresponsalapp.ModelMain;

import android.content.Context;

public interface InterfaceMain {


    //  INTERFAZ DEL VIEW -- LOGIN

    public interface LoginView {

        void setUsuarioError();

        void setContrasenaError();

    }




    //INTERFAZ DEL PRESENTADOR -- LOGIN

    public interface LoginPresenter {

        void validarCredenciales(Context context, String usuario, String contrasena);
        void ingresoIncorrecto();

    }





    //INTERFAZ  DEL MODELO - LOGIN

    public interface LoginInteractor {


        interface finalLoginListener {

            void onUsuarioError();

            void onContrasenaEror();

            void onIngresoCorrecto();


        }

        void validarCedencialesUsuario(Context context, String username, String password, InterfaceMain.LoginInteractor.finalLoginListener listener);


    }
}
