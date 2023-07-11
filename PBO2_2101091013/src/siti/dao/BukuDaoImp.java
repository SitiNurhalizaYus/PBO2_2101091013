/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.dao;

import siti.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author siti nurhaliza yus
 */

public class BukuDaoImp implements BukuDao{
    
    @Override
    public void insert(Connection con, Buku buku) throws Exception{
        String sql = "insert into buku values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKodebuku());
        ps.setString(2, buku.getJudul());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.executeUpdate();
    }

   
    @Override
    public void update(Connection con, Buku buku) throws Exception {
        String sql = 
                "update buku set judul=?, pengarang=?, penerbit=? where kodebuku=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getJudul());
        ps.setString(2, buku.getPengarang());
        ps.setString(3, buku.getPenerbit());
        ps.setString(4, buku.getKodebuku());
        ps.executeUpdate();
    }

    @Override
    public void delete(Connection con, Buku buku) throws Exception {
        String sql = "delete from buku " + "where kodebuku = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, buku.getKodebuku());
        ps.executeUpdate();
    }

    
    @Override
    public Buku getBuku(Connection con, String kode) throws Exception {
        String sql = "select * from buku where kodebuku = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, kode);
        ResultSet rs = ps.executeQuery();
        Buku buku = null;
        if (rs.next()){
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
        }
        return buku;
    }

 
    @Override
    public List<Buku> getAllBuku(Connection con) throws Exception {
        String sql = "select * from buku";
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Buku> list = new ArrayList<>();
        Buku buku = null;
        while (rs.next()) {
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudul(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            list.add(buku);
        }
        return list;
    }

}