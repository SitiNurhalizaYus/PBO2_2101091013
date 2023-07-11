 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.model;

/**
 *
 * @author siti nurhaliza yus
 */
public class Peminjaman {
    private String kodeanggota;
    private String kodebuku;
    private String tglpinjam;
    private String tglkembali;

    public Peminjaman() {
    }

    public Peminjaman(String kodeanggota, String kodebuku, String tglpinjam, String tglkembali) {
        this.kodeanggota = kodeanggota;
        this.kodebuku = kodebuku;
        this.tglpinjam = tglpinjam;
        this.tglkembali = tglkembali;
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

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }
}
