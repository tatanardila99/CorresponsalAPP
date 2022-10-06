package com.semillero.corresponsalapp.ViewsAdmin;

public class ItemInicioAdmin {
    private String opcion;
    private int itemsOpcion;

    public ItemInicioAdmin(String opcion, int itemsOpcion) {
        this.opcion = opcion;
        this.itemsOpcion = itemsOpcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public int getItemsOpcion() {
        return itemsOpcion;
    }
}
