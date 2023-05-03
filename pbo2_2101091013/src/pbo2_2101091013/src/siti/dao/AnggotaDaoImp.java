/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import siti.model.Anggota;

/**
 *
 * @author siti nurhaliza yus
 */
public class AnggotaDaoImp implements AnggotaDao {
    @Override
    public void insert( Connection con,Anggota anggota) throws Exception {
        String sql = "Insert into anggota values (?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,anggota.getKodeanggota());
        ps.setString(2,anggota.getNamaanggota());
        ps.setString(3,anggota.getAlamat());
        ps.setString(4,anggota.getJeniskelamin());
        ps.executeUpdate();
       
    }

    @Override
    public void update( Connection con,Anggota anggota) throws Exception {
        String sql = "update anggota set namaanggota=?, alamat=?, jekel=? where kodeanggota=?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,anggota.getNamaanggota());
        ps.setString(2,anggota.getAlamat());
        ps.setString(3,anggota.getJeniskelamin());
        ps.setString(4,anggota.getKodeanggota());
        ps.executeUpdate();
    }

    @Override
    public void delete(Connection con,Anggota anggota) throws Exception {
        String sql = "delete from anggota " + "where kodeanggota=?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,anggota.getKodeanggota());
        ps.executeUpdate();
    }

   

    @Override
    public Anggota getAnggota(Connection con,String kode) throws Exception {
        String sql = "select * from anggota " + "where kodeanggota= ?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,kode);
        ResultSet rs = ps.executeQuery ();
        Anggota anggota= null;
        if (rs.next ()){
            anggota = new Anggota();
            anggota.setKodeanggota(rs.getString(1));
            anggota.setNamaanggota(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJeniskelamin(rs.getString(4));
        }
        return anggota;
    }

    @Override
    public List<Anggota> getAllAnggota(Connection con) throws Exception {
        String sql = "select * from anggota";
        PreparedStatement ps= con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery ();
        List<Anggota> list = new ArrayList<> ();
        Anggota anggota= null;
        while (rs.next ()){
            anggota = new Anggota();
            anggota.setKodeanggota(rs.getString(1));
            anggota.setNamaanggota(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJeniskelamin(rs.getString(4));
            list.add(anggota);
        }
        return list;
       
    }

    public Anggota getAllAnggota(Connection con, String kode) throws Exception {
       
        String sql = "select * from anggota"+ "where kodeanggota=?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,kode);
        ResultSet rs = ps.executeQuery ();
        Anggota anggota= null;
        if (rs.next ()){
            anggota = new Anggota();
            anggota.setKodeanggota(rs.getString(1));
            anggota.setNamaanggota(rs.getString(2));
            anggota.setAlamat(rs.getString(3));
            anggota.setJeniskelamin(rs.getString(4));
        }
        return anggota;
    }   
    
}
