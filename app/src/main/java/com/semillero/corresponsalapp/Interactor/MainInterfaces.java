package com.semillero.corresponsalapp.Interactor;

import android.content.Context;

public interface MainInterfaces {

    //  INTERFAZ DEL VIEW -- LOGIN

    public interface LoginView {

        void setUsuarioError();

        void setContrasenaError();

        void setErrorIngreso();

        //  void navegacionPrincipal();

    }

    //INTERFAZ DEL PRESENTADOR -- LOGIN

    public interface LoginPresenter {

        void validarIngreso(Context context, String usuario, String contrasena);
    }


    public interface LoginInteractor {


        interface finalLoginListener {

            void activarEmailError();

            void activarContrasenaEror();

            void activarIngresoCorrecto();


        }

        void validarUsuario(Context context, String username, String password, MainInterfaces.LoginInteractor.finalLoginListener listener);
    }
}
