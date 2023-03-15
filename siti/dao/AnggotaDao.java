/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siti.dao;

import java.sql.Connection;
import siti.model.Anggota;

/**
 *
 * @author siti nurhaliza yus
 */
public interface AnggotaDao {
    void insert(Connection con, Anggota anggota)throws Exception;
    
}
