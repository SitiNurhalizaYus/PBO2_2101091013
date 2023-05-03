/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2_2101091013;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import siti.dao.Koneksi;

/**
 *
 * @author siti nurhaliza yus
 */
public class PBO2_2101091013 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Koneksi koneksi = new Koneksi();
            Connection con = koneksi.getKoneksi();
            JOptionPane.showMessageDialog(null, "Koneksi OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error :" + ex.getMessage());
            Logger.getLogger(PBO2_2101091013.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
