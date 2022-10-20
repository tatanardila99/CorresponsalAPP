package com.semillero.corresponsalapp.Entidades;

public class Clientes {

    private int id;
    private String nombre;
    private String cedula;
    private String saldo;
    private String cuenta;
    private String pin;




    public void Clientes(int id, String nombre, String cedula, String saldo, String cuenta, String pin) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.saldo = saldo;
        this.cuenta = cuenta;
        this.pin = pin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
