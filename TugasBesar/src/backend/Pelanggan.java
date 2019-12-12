/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Gopla
 */
public class Pelanggan {
    protected String namaPelanggan;

    public Pelanggan() {
    }

    public Pelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }
}
