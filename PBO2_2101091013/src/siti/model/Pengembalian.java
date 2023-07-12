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
    public String kodeanggota;
    public String kodebuku;
    public String tglpinjam;
    public String tgldikembalikan;
    private int terlambat;
    private double denda;

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

    public String getTgldikembalikan() {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date tgl = new Date();
        tgldikembalikan = s.format(tgl);
        return tgldikembalikan;
    }

    public void setTgldikembalikan(String tgldikembalikan) {
       
        this.tgldikembalikan = tgldikembalikan;
    }

    public int getTerlambat() {
        return terlambat;
    }

    public void setTerlambat(int terlambat) {
        this.terlambat = terlambat;
    }

    public double getDenda() {
        denda = terlambat= terlambat;
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }
    
}