/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_a.model;

/**
 *
 * @author siti nurhaliza yus
 */
public class Pelanggan {
    private String kode;
    private String nama;
    private Integer mbi;
    private Integer mbl;
    private Integer tarif;
    private Integer potongan;
    private Integer total;
    public Object setMbi;

    //contructor
    public Pelanggan(String kode, String nama, Integer mbi, Integer mbl, Integer tarif, Integer potongan, Integer total) {
        this.kode = kode;
        this.nama = nama;
        this.mbi = mbi;
        this.mbl = mbl;
        this.tarif = tarif;
        this.potongan = potongan;
        this.total = total;
    }

    public Pelanggan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //get set

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getMbi() {
        return mbi;
    }

    public void setMbi(Integer mbi) {
        this.mbi = mbi;
    }

    public Integer getMbl() {
        return mbl;
    }

    public void setMbl(Integer mbl) {
        this.mbl = mbl;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }

    public Integer getPotongan() {
        return potongan;
    }

    public void setPotongan(Integer potongan) {
        this.potongan = potongan;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setNama() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
