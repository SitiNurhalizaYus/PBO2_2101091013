/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.dao;

import siti.model.Peminjaman;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author siti nurhaliza yus
 */
    
public interface PeminjamanDao {
    public void insert(Connection con, Peminjaman peminjaman) throws Exception;
    public void update(Connection con, Peminjaman peminjaman) throws Exception;
    public void delete(Connection con, Peminjaman peminjaman) throws Exception;
    public Peminjaman getPeminjaman(Connection con, 
            String kodeanggota, String kodebuku, String tglpinjam, String tglkembali) throws Exception;
    public List<Peminjaman> getAllPeminjaman(Connection con) throws Exception;
}

