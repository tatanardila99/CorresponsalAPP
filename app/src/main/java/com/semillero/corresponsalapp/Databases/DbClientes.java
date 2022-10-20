package com.semillero.corresponsalapp.Databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.semillero.corresponsalapp.Entidades.Clientes;

public class DbClientes  extends DbHelper{

    Context context;

    public DbClientes(@Nullable Context context) {
        super(context,"corresponsalApp.db",null, 1);
        this.context = context;
    }



    // METODO PARA CREAR CLIENTE

    public long crearCliente(Clientes clientes) {
        long id = 0;

        try {

            DbHelper dbHelper = new DbHelper(context, "corresponsalApp.db", null, 1);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(nombreCliente, clientes.getNombre());
            values.put(cedulaCliente, clientes.getCedula());
            values.put(saldoCliente, clientes.getSaldo());
            values.put(cuentaCliente, clientes.getCuenta());
            values.put(pinCliente, clientes.getPin());


            id = db.insert(TABLE_CLIENTES, null, values);


        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }


    // METODO PARA CONSULTAR CLIENTE

    public Cursor consultarCliente(String cedula) throws SQLException {
        DbHelper dbHelper = new DbHelper(context, "corresponsalApp.db", null, 1);
        Cursor mCursor = null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        /*mCursor = this.getReadableDatabase().query("t_usuarios", new String[]{"idUsuario", "nombreUsuario", "telefonoUsuario","contrasenaUsuario", "correo_ElectronicoUsuario"}, "correo_ElectronicoUsuario like '" + usuario + "' and contrasenaUsuario like '" + contrasena + "'", null, null, null, null);*/

        mCursor = db.rawQuery("SELECT * FROM " + TABLE_CLIENTES + " WHERE " + cedulaCliente,null);
        return mCursor;
    }



}
