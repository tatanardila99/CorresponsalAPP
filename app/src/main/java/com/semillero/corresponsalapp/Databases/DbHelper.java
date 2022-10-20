package com.semillero.corresponsalapp.Databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "corresponsalApp.db";

    public static final String TABLE_CLIENTES = "t_clientes";
    public static final String idCliente = "idCliente";
    public static final String nombreCliente = "nombreCliente";
    public static final String cedulaCliente = "cedulaCliente";
    public static final String saldoCliente = "saldoCliente";
    public static final String cuentaCliente = "cuentaCliente";
    public static final String pinCliente = "pinCliente";

    public static final String TABLE_CORRESPONSAL = "t_corresponsal";
    public static final String idCorresponsal = "idCorresponsal";
    public static final String nombreCorresponsal = "nombreCorresponsal";
    public static final String nitCorresponsal = "nitCorresponsal";
    public static final String correoCorresponsal = "correoCorresponsal";
    public static final String cuentaCorresponsal = "cuentaCorresponsal";
    public static final String saldoCorresponsal = "saldoCliente";
    public static final String contrasenaCorresponsal = "contrasenaCorresponsal";

    public static final String TABLE_PAGOS_TARJETA = "t_pago_tarjeta";
    public static final String idPagoTarjeta = "idPagoTarjeta";
    public static final String numTarjetaCliente = "numTarjetaCliente";
    public static final String id_clientePagoTarjeta = "id_clientePagoTarjeta";
    public static final String fechaPagoTarjeta = "fechaPagoTarjeta";
    public static final String cuotasPagoTarjeta = "cuotasPagoTarjeta";
    public static final String valorPagoTarjeta = "valorPagoTarjeta";


    public static final String TABLE_RETIROS = "t_retiros";
    public static final String idRetiro = "idRetiro";
    public static final String cedulaRetiroCliente = "cedulaRetiroCliente";
    public static final String fechaRetiroCliente = "fechaRetiroCliente";
    public static final String valorRetiroCliente = "valorRetiroCliente";

    public static final String TABLE_DEPOSITO = "t_deposito";
    public static final String idDeposito = "idDeposito";
    public static final String cedulaRecibeDeposito = "cedulaRecibeDeposito";
    public static final String cedulaEnviaDeposito = "cedulaEnviaDeposito";
    public static final String valorDeposito = "valorDeposito";
    public static final String fechaDeposito = "fechaRetiroCliente";



    public static final String TABLE_TRANFERENCIA = "t_transferencia";
    public static final String idTransferencia = "idTransferencia ";
    public static final String cedulaRecibeTransferencia = "cedulaRecibeTransferencia";
    public static final String cedulaEnviaTransferencia = "cedulaEnviaTransferencia";
    public static final String valorTransferencia = "valorTransferencia";
    public static final String fechaTransferencia = "fechaTransferencia";


    public DbHelper(@Nullable Context context,String s , Object o , int i) {
        super( context, DATABASE_NOMBRE, null, DATABASE_VERSION );
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL( " CREATE TABLE " + TABLE_CLIENTES + "(" +
                idCliente + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                nombreCliente + " TEXT NOT NULL," +
                cedulaCliente + " TEXT NOT NULL," +
                cuentaCliente + " TEXT NOT NULL," +
                saldoCliente + " TEXT NOT NULL," +
                pinCliente + " TEXT NOT NULL)" );


        sqLiteDatabase.execSQL( " CREATE TABLE " + TABLE_CORRESPONSAL + "(" +
                idCorresponsal + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                nombreCorresponsal + " TEXT NOT NULL," +
                nitCorresponsal + " TEXT NOT NULL," +
                correoCorresponsal + " TEXT NOT NULL," +
                cuentaCorresponsal + " TEXT NOT NULL," +
                saldoCorresponsal + " TEXT NOT NULL," +
                contrasenaCorresponsal + " TEXT NOT NULL)" );


        sqLiteDatabase.execSQL( " CREATE TABLE " + TABLE_PAGOS_TARJETA + "(" +
                idPagoTarjeta + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                numTarjetaCliente + " TEXT NOT NULL," +
                id_clientePagoTarjeta + " TEXT NOT NULL," +
                fechaPagoTarjeta + " TEXT NOT NULL," +
                cuotasPagoTarjeta + " TEXT NOT NULL," +
                valorPagoTarjeta + " TEXT NOT NULL)" );


        sqLiteDatabase.execSQL( " CREATE TABLE " + TABLE_RETIROS + "(" +
                idRetiro + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                cedulaRetiroCliente + " TEXT NOT NULL," +
                fechaRetiroCliente + " TEXT NOT NULL," +
                valorRetiroCliente + " TEXT NOT NULL)" );



        sqLiteDatabase.execSQL( " CREATE TABLE " + TABLE_DEPOSITO + "(" +
                idDeposito + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                cedulaRecibeDeposito + " TEXT NOT NULL," +
                cedulaEnviaDeposito + " TEXT NOT NULL," +
                valorDeposito + " TEXT NOT NULL," +
                fechaDeposito + " TEXT NOT NULL)" );


        sqLiteDatabase.execSQL( " CREATE TABLE " + TABLE_TRANFERENCIA + "(" +
                idTransferencia + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                cedulaRecibeTransferencia + " TEXT NOT NULL," +
                cedulaEnviaTransferencia + " TEXT NOT NULL," +
                valorTransferencia + " TEXT NOT NULL," +
                fechaTransferencia + " TEXT NOT NULL)" );

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL( "DROP TABLE " + TABLE_CLIENTES );
        sqLiteDatabase.execSQL( "DROP TABLE " + TABLE_CORRESPONSAL );
        sqLiteDatabase.execSQL( "DROP TABLE " + TABLE_PAGOS_TARJETA );
        sqLiteDatabase.execSQL( "DROP TABLE " + TABLE_RETIROS );
        sqLiteDatabase.execSQL( "DROP TABLE " + TABLE_DEPOSITO );
        sqLiteDatabase.execSQL( "DROP TABLE " + TABLE_TRANFERENCIA);

        onCreate( sqLiteDatabase );

    }
}
