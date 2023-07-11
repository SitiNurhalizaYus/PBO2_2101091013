/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_a.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import siti.dao.Koneksi;
import uts_a.dao.PelangganDao;
import uts_a.dao.PelangganDaoImp;
import uts_a.model.Pelanggan;
import uts_a.view.FormPelanggan;

/**
 *
 * @author siti nurhaliza yus
 */
public class PelangganController {
    private FormPelanggan formPelanggan;
    private Pelanggan pelanggan;
    private PelangganDao dao;
    private Connection con;
    private Koneksi K;
    private Object JOptionePane;
    public PelangganController(FormPelanggan formPelanggan) throws SQLException{
        try {
            this.formPelanggan = formPelanggan;
            dao= new PelangganDaoImp();
            K = new Koneksi();
            con = K.getKoneksi();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
  
        
    }
    
       public void insert(){
        
        try {
            pelanggan = new Pelanggan();
            pelanggan.setKode(formPelanggan.getkode().toString());
            pelanggan.setNama(formPelanggan.getName());
            pelanggan.setMbi((Integer)formPelanggan.getMbi());
            pelanggan.setMbl((Integer)formPelanggan.getMbl());
//            pelanggan.setTarif((Integer)formPelanggan.getTarif());
//            pelanggan.setPotongan(Integer)formPelanggan.getPotongan();
           
            dao.insert(con,pelanggan);
            JOptionPane.showMessageDialog(formPelanggan, "Entri Ok");
            
            
        } catch (Exception ex) {
            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
     }
        
        public void update(){
        try {
            pelanggan = new Pelanggan();
            pelanggan.setKode(formPelanggan.getkode().toString());
            pelanggan.setNama();
            dao.update(con,pelanggan);
            JOptionPane.showMessageDialog(formPelanggan, "Update Ok");
        } catch (Exception ex) {
            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
     public void delete(){
     
        try {
            dao.delete(con, pelanggan);
            JOptionPane.showMessageDialog(formPelanggan, "Delete Ok");
        } catch (Exception ex) {
            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void cari(){
        
//        try {
//            String kode = formPelanggan.getkode().getText();
//            pelanggan = dao.getPelanggan(con,kode);
//            if(pelanggan != null){
//                formPelanggan.getName().setText(pelanggan.getNama());
//                formPelanggan.getMbi().setText(pelanggan.getMbi());
//            }else{
//                JOptionPane.showMessageDialog(formPelanggan, "Data Tidak Ada");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
     }
     
//     public void tampil(){
//        try {
//            DefaultTableModel tabel =(DefaultTableModel) formPelanggan.getTblPelanggan();
//            tabel.setRowCount(0);
//            List<Pelanggan> list= dao.getAllPelanggan(con);
//            for (Pelanggan pelanggan1 : list){
//                Object[] row= {
//                    pelanggan1.getKode(),
//                    pelanggan1.getNama(),
//                    pelanggan1.getMbi(),
//                    pelanggan1.getMbl(),
//                    pelanggan1.getTarif(),
//                    pelanggan1.getPotongan(),
//                    pelanggan1.getTotal()
//                };
//                tabel.addRow(row);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PelangganController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        }

    public void clearForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public void clearForm() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
     
}
