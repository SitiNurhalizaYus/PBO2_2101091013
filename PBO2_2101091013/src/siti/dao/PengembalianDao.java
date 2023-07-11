/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.dao;

import java.sql.Connection;
import java.util.List;
import siti.model.Pengembalian;

/**
 *
 * @author siti nurhaliza yus
 */
public interface PengembalianDao {
    public void insert(Connection con, Pengembalian pengembalian) throws Exception;
    public void update(Connection con, Pengembalian pengembalian) throws Exception;
    public void delete(Connection con, Pengembalian pengembalian) throws Exception;
    public Pengembalian getPengembalian(Connection con, 
            String kodeanggota, String kodebuku, String tglpinjam, String tglkembalikan, String terlambat, String denda) throws Exception;
    public List<Pengembalian> getAllPengembalian(Connection con) throws Exception;
    public int selisihTanggal(Connection con, String tgl1, String tgl2) throws Exception;
//    select datediff('2023-01-03','2023-01-01') as hasil
}
