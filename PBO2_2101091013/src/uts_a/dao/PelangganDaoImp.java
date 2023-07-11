/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_a.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uts_a.model.Pelanggan;

/**
 *
 * @author siti nurhaliza yus
 */
public class PelangganDaoImp implements PelangganDao{
    @Override
    public void insert( Connection con,Pelanggan pelanggan) throws Exception {
        String sql = "Insert into pelanggan values (?,?,?,?,?,?)";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,pelanggan.getKode());
        ps.setString(2,pelanggan.getNama());
        ps.setInt(3,pelanggan.getMbi());
        ps.setInt(4,pelanggan.getMbl());
        ps.setInt(5,pelanggan.getTarif());
        ps.setInt(6,pelanggan.getPotongan());
        ps.executeUpdate();
       
    }

    @Override
    public void update( Connection con,Pelanggan pelanggan) throws Exception {
        String sql = "update pelanggan set nama=?, mbi=?, mbl=? where kode=?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,pelanggan.getNama());
        ps.setInt(2,pelanggan.getMbi());
        ps.setInt(3,pelanggan.getMbl());
        ps.setInt(4,pelanggan.getTarif());
        ps.setInt(5,pelanggan.getPotongan());
        ps.executeUpdate();
    }

    @Override
    public void delete(Connection con,Pelanggan pelanggan) throws Exception {
        String sql = "delete from pelanggan " + "where kode=?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,pelanggan.getKode());
        ps.executeUpdate();
    }

  
    @Override
    public Pelanggan getPelanggan(Connection con,String kode) throws Exception {
        String sql = "select * from pelanggan " + "where kode= ?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,kode);
        ResultSet rs = ps.executeQuery ();
        Pelanggan pelanggan= null;
        if (rs.next ()){
            pelanggan = new Pelanggan();
            pelanggan.setKode(rs.getString(1));
            pelanggan.setNama(rs.getString(2));
            pelanggan.setMbi(rs.getInt(3));
            pelanggan.setMbl(rs.getInt(4));
            pelanggan.setTarif(rs.getInt(5));
            pelanggan.setPotongan(rs.getInt(6));
        }
        return pelanggan;
    }


    public List<Pelanggan> getAllPelanggan(Connection con) throws Exception {
        String sql = "select * from pelanggan";
        PreparedStatement ps= con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery ();
        List<Pelanggan> list = new ArrayList<> ();
        Pelanggan pelanggan= null;
        while (rs.next ()){
            pelanggan = new Pelanggan();
            pelanggan.setKode(rs.getString(1));
            pelanggan.setNama(rs.getString(2));
            pelanggan.setMbi(rs.getInt(3));
            pelanggan.setMbl(rs.getInt(4));
            pelanggan.setTarif(rs.getInt(4));
            pelanggan.setPotongan(rs.getInt(4));
            list.add(pelanggan);
        }
        return list;
       
    }

    public Pelanggan getAllPelanggan(Connection con, String kode) throws Exception {
        String sql = "select * from pelanggan"+ "where kodepelanggan=?";
        PreparedStatement ps= con.prepareStatement(sql);
        ps.setString(1,kode);
        ResultSet rs = ps.executeQuery ();
        Pelanggan pelanggan= null;
        if (rs.next ()){
            pelanggan = new Pelanggan();
            pelanggan.setKode(rs.getString(1));
            pelanggan.setNama(rs.getString(2));
            pelanggan.setMbi(rs.getInt(3));
            pelanggan.setMbl(rs.getInt(4));
            pelanggan.setTarif(rs.getInt(5));
            pelanggan.setPotongan(rs.getInt(6));
        }
        return pelanggan;
    }   
}

