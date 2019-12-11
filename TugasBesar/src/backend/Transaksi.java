/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gopla
 */
public class Transaksi implements Tax{
    private int id_transaksi, id_user, berat, total;
    private String jenisCuci, tglTransaksi, tglKembali, nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Transaksi(int id_transaksi, int id_user, int berat, int total, String jenisCuci, String tglTransaksi, String tglKembali, String nama) {
        this.id_transaksi = id_transaksi;
        this.id_user = id_user;
        this.berat = berat;
        this.total = total;
        this.jenisCuci = jenisCuci;
        this.tglTransaksi = tglTransaksi;
        this.tglKembali = tglKembali;
        this.nama = nama;
    }

    public Transaksi() {
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getJenisCuci() {
        return jenisCuci;
    }

    public void setJenisCuci(String jenisCuci) {
        this.jenisCuci = jenisCuci;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }
    
    public Transaksi getById(int key){
        Transaksi transaksi = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM transaksi " +
                                            "WHERE id_transaksi = '"+ key +"'");
        try {
            while (rs.next()) {
                transaksi = new Transaksi();
                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                transaksi.setId_user(rs.getInt("id_user"));
                transaksi.setNama(rs.getString("nama"));
                transaksi.setTglTransaksi(rs.getString("tgl_transaksi"));
                transaksi.setTglKembali(rs.getString("tgl_kembali"));
                transaksi.setJenisCuci(rs.getString("jenis_cuci"));
                transaksi.setBerat(rs.getInt("berat"));
                transaksi.setTotal(rs.getInt("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaksi;
    }
    
    public ArrayList<Transaksi> getAll(){
        ArrayList<Transaksi> listTransaksi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM transaksi ");
        try {
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                transaksi.setId_user(rs.getInt("id_user"));
                transaksi.setNama(rs.getString("nama"));
                transaksi.setTglTransaksi(rs.getString("tgl_transaksi"));
                transaksi.setTglKembali(rs.getString("tgl_kembali"));
                transaksi.setJenisCuci(rs.getString("jenis_cuci"));
                transaksi.setBerat(rs.getInt("berat"));
                transaksi.setTotal(rs.getInt("total"));
                listTransaksi.add(transaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    
    public ArrayList<Transaksi> search(String key){
        ArrayList<Transaksi> listTransaksi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM transaksi "+
                                            " WHERE jenis_cuci like '%"+ key +"%' OR"+
                                            " nama like '%"+ key +"%'");
        try {
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId_transaksi(rs.getInt("id_transaksi"));
                transaksi.setId_user(rs.getInt("id_user"));
                transaksi.setNama(rs.getString("nama"));
                transaksi.setTglTransaksi(rs.getString("tgl_transaksi"));
                transaksi.setTglKembali(rs.getString("tgl_kembali"));
                transaksi.setJenisCuci(rs.getString("jenis_cuci"));
                transaksi.setBerat(rs.getInt("berat"));
                transaksi.setTotal(rs.getInt("total"));
                listTransaksi.add(transaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTransaksi;
    }
    
    public void save(){
        
        System.out.println(getId_user());
        if (getById(id_transaksi).getId_transaksi() == 0) {
            String SQL = "INSERT INTO transaksi(id_user,nama, tgl_kembali, " +
                        " jenis_cuci, berat, total) VALUES ('"+ id_user +"', '"+ nama +"', " +
                        "NOW() + INTERVAL 2 DAY, '"+jenisCuci+"', '"+berat+"', "+
                        "'"+getHargaPajak()+"')";
            this.id_transaksi = DBHelper.insertQueryGetId(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM transaksi WHERE id_transaksi = '"+ this.id_transaksi +"'";
        DBHelper.executeQuery(SQL);
    }

    @Override
    public int getHargaPajak() {
        return total + (total * 5 / 100);
    }
    
    
    
}
