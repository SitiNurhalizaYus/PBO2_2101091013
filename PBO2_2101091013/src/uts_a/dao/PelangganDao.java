/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts_a.dao;

import java.sql.Connection;
import java.util.List;
import uts_a.model.Pelanggan;

/**
 *
 * @author siti nurhaliza yus
 */
public interface PelangganDao {
    public void insert(Connection con,Pelanggan pelanggan) throws Exception;
    public void update(Connection con,Pelanggan pelanggan) throws Exception;
    public void delete(Connection con,Pelanggan pelanggan) throws Exception;
    public Pelanggan getPelanggan(Connection con,String kode) throws Exception;
    public List<Pelanggan> getAllPelanggan(Connection con) throws Exception;
}
