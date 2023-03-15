/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private AnggotaDao anggotaDao;
    private Connection con;
    private Koneksi koneksi;
    
    public AnggotaController(FormAnggota formAnggota){
        try {
            this.formAnggota = new FormAnggota();
            anggotaDao = new AnggotaDaoImp();
            con = new Koneksi().getKoneksi();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void bersihForm(){
            formAnggota.getTxtKodeAnggota().setText("");
            formAnggota.getTxtNamaAnggota().setText("");           
        }
        
        public void isiCboJenisKelamin(){
            formAnggota.getCboJeKel().removeAllItems();
            formAnggota.getCboJeKel().addItem("L");
            formAnggota.getCboJeKel().addItem("P");
        }
        
    }

