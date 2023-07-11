/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.model;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author siti nurhaliza yus
 */
public class Pengembalian {
    private String kodeanggota;
    private String kodebuku;
    private String tglpinjam;
    private String tglkembalikan;
    private int terlambat;
    private double denda;
    private String tglkembali;
    
    public Pengembalian(){
        
    }

    public String getKodeanggota() {
        return kodeanggota;
    }

    public void setKodeanggota(String kodeanggota) {
        this.kodeanggota = kodeanggota;
    }

    public String getKodebuku() {
        return kodebuku;
    }

    public void setKodebuku(String kodebuku) {
        this.kodebuku = kodebuku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }
    
    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
    
    public String getTglkembali() {
        return tglkembali;
    }

    public String getTglkembalikan() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date tgl = new Date();
        tglkembalikan = s.format(tgl);
        return tglkembalikan;
    }

    public void setTglkembalikan(String tglkembalikan) {
        this.tglkembalikan = tglkembalikan;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public double getDenda() {
        denda = terlambat * 1000;
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    public void setDenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
