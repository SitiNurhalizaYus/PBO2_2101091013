/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.controller;

/**
 *
 * @author siti nurhaliza yus
 */
import siti.dao.AnggotaDao;
import siti.dao.BukuDao;
import siti.dao.PeminjamanDao;
import siti.dao.Koneksi;
import siti.dao.AnggotaDaoImp;
import siti.dao.BukuDaoImp;
import siti.dao.PeminjamanDaoImp;
import siti.model.Anggota;
import siti.model.Buku;
import siti.model.Peminjaman;
import siti.view.FormPeminjaman;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author siti nurhaliza yus
 */
public class PeminjamanController {
    FormPeminjaman formPeminjaman;
    Peminjaman peminjaman;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    Connection con;

    public PeminjamanController(FormPeminjaman formPeminjaman) {
        try {
            this.formPeminjaman = formPeminjaman;
            peminjamanDao = new PeminjamanDaoImp();
            anggotaDao = new AnggotaDaoImp();
            bukuDao = new BukuDaoImp();
            Koneksi k = new Koneksi();
            con = k.getKoneksi();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }
    
    public void isiCombo(){
        try {
            formPeminjaman.getCboKodeanggota().removeAllItems();
            formPeminjaman.getCboKodebuku().removeAllItems();
            List<Anggota> anggotaList = anggotaDao.getAllAnggota(con);
            List<Buku> bukuList = bukuDao.getAllBuku(con);
            for (Anggota anggota : anggotaList) {
                formPeminjaman.getCboKodeanggota()
                        .addItem(anggota.getKodeanggota()+"-"+anggota.getNamaanggota());
            }
            for (Buku buku : bukuList) { 
                formPeminjaman.getCboKodebuku().addItem(buku.getKodebuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            peminjaman = new Peminjaman();
            peminjaman.setKodeanggota(formPeminjaman.getCboKodeanggota()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setKodebuku(formPeminjaman.getCboKodebuku().getSelectedItem().toString());
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.insert(con, peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Entri Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void update(){
        try {
            peminjaman = new Peminjaman();
            peminjaman.setKodeanggota(formPeminjaman.getCboKodeanggota()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setKodebuku(formPeminjaman.getCboKodebuku().getSelectedItem().toString());
            peminjaman.setTglpinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglkembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.update(con, peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(formPeminjaman, ex.getMessage());
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void delete() {
        try {
            peminjamanDao.delete(con, peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Delete Ok");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void tabelKlik(){
        try {
            String kodeanggota = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman().getSelectedRow(), 0).toString();
            String kodebuku = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman().getSelectedRow(), 1).toString();
            String tglpinjam = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman().getSelectedRow(), 2).toString();
            String tglkembali = formPeminjaman.getTabelPeminjaman()
                    .getValueAt(formPeminjaman.getTabelPeminjaman().getSelectedRow(), 3).toString();
            peminjaman = peminjamanDao.getPeminjaman(con, kodeanggota, kodebuku, tglpinjam, tglkembali);
            if(peminjaman!=null){
                Anggota anggota = anggotaDao.getAnggota(con, peminjaman.getKodeanggota());
                formPeminjaman.getCboKodeanggota()
                        .setSelectedItem(anggota.getKodeanggota()+"-"+anggota.getNamaanggota());
                formPeminjaman.getCboKodebuku().setSelectedItem(peminjaman.getKodebuku());
                formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglpinjam());
                formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglkembali());
             }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabel = (DefaultTableModel) formPeminjaman.getTabelPeminjaman().getModel();
            tabel.setRowCount(0);
            List<Peminjaman> list = peminjamanDao.getAllPeminjaman(con);
            for (Peminjaman peminjaman1 : list) { 
                Object[] row = {
                    peminjaman1.getKodeanggota(),
                    peminjaman1.getKodebuku(),
                    peminjaman1.getTglpinjam(),
                    peminjaman1.getTglkembali()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}

