/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import siti.model.Anggota;

/**
 *
 * @author siti nurhaliza yus
 */
public class AnggotaDaoImp implements AnggotaDao {

    @Override
    public void insert(Connection con, Anggota anggota) throws Exception{
        String sql = "insert into anggota values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql); //menghasilkan ekekusi
        ps.setString(1, anggota.getKodeanggota());
        ps.setString(2, anggota.getNamaanggota());
        ps.setString(3, anggota.getAlamat());
        ps.setString(4, anggota.getJeniskelamin());
        ps.executeUpdate();
    }
    
}
