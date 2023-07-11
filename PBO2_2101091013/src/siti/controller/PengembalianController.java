/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import siti.dao.AnggotaDao;
import siti.dao.AnggotaDaoImp;
import siti.dao.BukuDao;
import siti.dao.BukuDaoImp;
import siti.dao.Koneksi;
import siti.dao.PeminjamanDao;
import siti.dao.PeminjamanDaoImp;
import siti.dao.PengembalianDao;
import siti.dao.PengembalianDaoImp;
import siti.model.Anggota;
import siti.model.Peminjaman;
import siti.model.Pengembalian;
import siti.view.FormPengembalian;

/**
 *
 * @author siti nurhaliza yus
 */
public class PengembalianController {
    FormPengembalian formPengembalian;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    PeminjamanDao peminjamanDao;
    PengembalianDao pengembalianDao;
    Pengembalian pengembalian;
    Connection connection;

    public PengembalianController(FormPengembalian formPengembalian) throws ClassNotFoundException {
        try {
            this.formPengembalian = formPengembalian;
            anggotaDao = new AnggotaDaoImp();
            bukuDao = new BukuDaoImp();
            peminjamanDao = new PeminjamanDaoImp();
            pengembalianDao = new PengembalianDaoImp();
            Koneksi k = new Koneksi();
            connection = k.getKoneksi();
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clearForm(){
        formPengembalian.getTxtTglPinjam().setText("");
        formPengembalian.getTxtTglKembali().setText("");
        formPengembalian.getTxtTglDikembalikan().setText("");
        formPengembalian.getTxtTerlambat().setText("");
        formPengembalian.getTxtDenda().setText("");
        formPengembalian.getTxtKodeAnggota().setText("");
        formPengembalian.getTxtKodebuku().setText("");
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabelModel = (DefaultTableModel)
                    formPengembalian.getTabelPengembalian().getModel();
            tabelModel.setRowCount(0);
            List<Pengembalian> list = pengembalianDao.getAllPengembalian(connection);
            for (Pengembalian p : list) {
                Anggota anggota = anggotaDao.getAnggota(connection, 
                        p.getKodeanggota());
                Peminjaman pinjam = peminjamanDao
                        .getPeminjaman(connection, p.getKodeanggota(), 
                                p.getKodebuku(), p.getTglpinjam(), p.getTglkembali());
                Object[] row = {
                    p.getKodeanggota(),
                    anggota.getNamaanggota(),
                    p.getKodebuku(),
                    p.getTglpinjam(),
                    p.getTglkembali(),
                    p.getTglkembalikan(),
                    p.getTerlambat(),
                    p.getDenda()
                };
                tabelModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPengembalian(){
        try {
            String kodeAnggota = formPengembalian.getTabelPengembalian()
                    .getValueAt(formPengembalian.getTabelPengembalian()
                            .getSelectedRow(), 0).toString();
            String kodebuku = formPengembalian.getTabelPengembalian()
                    .getValueAt(formPengembalian.getTabelPengembalian()
                            .getSelectedRow(), 1).toString();
            String tglpinjam = formPengembalian.getTabelPengembalian()
                    .getValueAt(formPengembalian.getTabelPengembalian()
                            .getSelectedRow(), 2).toString();
            String tglkembali = formPengembalian.getTabelPengembalian()
                    .getValueAt(formPengembalian.getTabelPengembalian()
                            .getSelectedRow(), 3).toString();
            pengembalian = new Pengembalian();
            Peminjaman peminjaman = peminjamanDao
                    .getPeminjaman(connection, kodeAnggota, kodebuku, tglpinjam, tglkembali);
            int terlambat = pengembalianDao
                    .selisihTanggal(connection, pengembalian.getTglkembalikan(),
                            peminjaman.getTglkembali());
            pengembalian.setTerlambat(terlambat);
            double denda = pengembalian.getDenda();
            formPengembalian.getTxtKodeAnggota().setText(kodeAnggota);
            formPengembalian.getTxtKodebuku().setText(kodebuku);
            formPengembalian.getTxtTglPinjam().setText(tglpinjam);
            formPengembalian.getTxtTglKembali().setText(peminjaman.getTglkembali()); 
            formPengembalian.getTxtTglDikembalikan().setText(pengembalian.getTglkembalikan());
            formPengembalian.getTxtTerlambat().setText(terlambat+""); 
            formPengembalian.getTxtDenda().setText(denda+"");
        } catch (Exception ex) {
            Logger.getLogger(PengembalianController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
