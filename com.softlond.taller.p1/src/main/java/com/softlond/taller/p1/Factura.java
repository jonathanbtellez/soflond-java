package com.softlond.taller.p1;

public class Factura extends Precio{
    private String emisor;
    private String cliente;

    public Factura(String emisor, String cliente) {
        this.emisor = emisor;
        this.cliente = cliente;
    }

    public void emitirFactura(){
        System.out.println("La factura fue creada por: "+emisor+" y dada al cliente: "+cliente);
    }
}
