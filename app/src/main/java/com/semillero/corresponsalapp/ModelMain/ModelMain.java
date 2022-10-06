package com.semillero.corresponsalapp.ModelMain;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ModelMain  implements  InterfaceMain.LoginInteractor{



    //Valida campos de usuario en vista login
    @Override
    public void validarCedencialesUsuario(Context context, String username, String password, finalLoginListener listener) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            listener.onUsuarioError();
            listener.onContrasenaEror();
        }

    }
}
