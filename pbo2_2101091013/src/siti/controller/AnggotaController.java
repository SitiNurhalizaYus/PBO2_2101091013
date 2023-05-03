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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import siti.dao.AnggotaDao;
import siti.dao.AnggotaDaoImp;
import siti.dao.Koneksi;
import siti.model.Anggota;
import siti.view.FormAnggota;

/**
 *
 * @author siti nurhaliza yus
 */
public class AnggotaController {
    
    private FormAnggota formAnggota;
    private Anggota anggota;
    private AnggotaDao dao;
    private Connection con;
    private Koneksi K;
    private Object JOptionePane;
    
    public AnggotaController(FormAnggota formAnggota){
        try {
            this.formAnggota = formAnggota;
            dao= new AnggotaDaoImp();
            K = new Koneksi();
            con = K.getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
  
        
    }
    
    public void clearForm(){
        formAnggota.getTxtKodeAnggota().setText("");
        formAnggota.getTxtNamaAnggota().setText("");
        formAnggota.getTxtAlamat().setText("");
           
    }
    
    public void isiCboJenisKelamin(){
        formAnggota.getCboJeKel().removeAllItems();
        formAnggota.getCboJeKel().addItem("L");
        formAnggota.getCboJeKel().addItem("P");
    }
       public void insert(){
        
        try {
            anggota = new Anggota();
            anggota.setKodeanggota(formAnggota.getTxtKodeAnggota().getText());
            anggota.setNamaanggota(formAnggota.getTxtNamaAnggota().getText());
            anggota.setAlamat(formAnggota.getTxtAlamat().getText());
            anggota.setJeniskelamin (formAnggota.getCboJeKel().getSelectedItem().toString());
            dao.insert(con,anggota);
            JOptionPane.showMessageDialog(formAnggota, "Entri Ok");
            
            
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
     }
        
        public void update(){
        try {
            anggota = new Anggota();
            anggota.setKodeanggota(formAnggota.getTxtKodeAnggota().getText());
            anggota.setNamaanggota(
                    formAnggota.getTxtNamaAnggota().getText());
            anggota.setAlamat(
                    formAnggota.getTxtAlamat().getText());
            anggota.setJeniskelamin (
                    formAnggota.getCboJeKel().getSelectedItem().toString());
            dao.update(con,anggota);
            JOptionPane.showMessageDialog(formAnggota, "Update Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     public void delete(){
     
        try {
            dao.delete(con, anggota);
            JOptionPane.showMessageDialog(formAnggota, "Delete Ok");
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void cari(){
        
        try {
            String kode = formAnggota.getTxtKodeAnggota().getText();
            anggota = dao.getAnggota(con,kode);
            if(anggota != null){
                formAnggota.getTxtNamaAnggota().setText(anggota.getNamaanggota());
                formAnggota.getTxtAlamat().setText(anggota.getAlamat());
                formAnggota.getCboJeKel().setSelectedItem(anggota.getJeniskelamin());
            }else{
                JOptionPane.showMessageDialog(formAnggota, "Data Tidak Ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
     }
     
     public void tampil(){
        try {
            DefaultTableModel tabel =(DefaultTableModel) formAnggota.getTblAnggota().getModel();
            tabel.setRowCount(0);
            List<Anggota> list= dao.getAllAnggota(con);
            for (Anggota anggota1 : list){
                Object[] row= {
                    anggota1.getKodeanggota(),
                    anggota1.getNamaanggota(),
                    anggota1.getAlamat(),
                    anggota1.getJeniskelamin()
                };
                tabel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
     
}



