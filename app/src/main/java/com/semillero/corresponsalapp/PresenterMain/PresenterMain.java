package com.semillero.corresponsalapp.PresenterMain;

import android.content.Context;
import android.text.TextUtils;

import com.semillero.corresponsalapp.ModelMain.InterfaceMain;

public class PresenterMain implements InterfaceMain.LoginPresenter, InterfaceMain.LoginInteractor.finalLoginListener{


    private InterfaceMain.LoginView loginView;
    private InterfaceMain.LoginInteractor loginInteractor;


    public PresenterMain(InterfaceMain.LoginView loginView, InterfaceMain.LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    @Override
    public void validarCredenciales(Context context, String usuario, String contrasena) {
        if (loginView!= null){
            loginView.setUsuarioError();
            loginView.setContrasenaError();
        }
        loginInteractor.validarCedencialesUsuario(context,usuario, contrasena, this);

    }

    @Override
    public void ingresoIncorrecto() {

    }

    @Override
    public void onUsuarioError() {
        if (loginView != null){
            loginView.setUsuarioError();
        }

    }

    @Override
    public void onContrasenaEror() {
        if (loginView != null){
            loginView.setContrasenaError();
        }

    }

    @Override
    public void onIngresoCorrecto() {

    }
}
