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
public class Anggota {
    private String kodeanggota;
    private String namaanggota;
    private String alamat;
    private String jeniskelamin;

   public Anggota(){
   
   }
    
    public Anggota(String kodeanggota, String namaanggota, String alamat, String jeniskelamin) {
        this.kodeanggota = kodeanggota;
        this.namaanggota = namaanggota;
        this.alamat = alamat;
        this.jeniskelamin = jeniskelamin;
    }
    
    public String getKodeanggota() {
        return kodeanggota;
    }

    public String getNamaanggota() {
        return namaanggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getJeniskelamin() {
        return jeniskelamin;
    }

    public void setKodeanggota(String kodeanggota) {
        this.kodeanggota = kodeanggota;
    }

    public void setNamaanggota(String namaanggota) {
        this.namaanggota = namaanggota;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }
    
    
}
