/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_baitaplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saotr
 */
public class Class_Modify {
    
       Connection conn;
         public Class_Modify(){
           try {
               String Stringconn = "jdbc:sqlserver://MIU:1433;databaseName=QuanLyThuVien";
               
               conn = DriverManager.getConnection(Stringconn, "sa", "admin");
           } catch (SQLException ex) {
               Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
           }
        
    }
    
      public ResultSet getData(String stringSQL){
        ResultSet rs = null;
        try {
            Statement state = conn.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
       
    }
      
       public int ExcuteSQLInsertBanDoc(String[] stringsSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO dbo.BanDoc( ID ,MaDoc ,  MaSach , TenNguoiDoc , NgayMuon , NgayTra , SoCMT ) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            statement.setString(6, stringsSQL[5]);
             statement.setString(7, stringsSQL[6]);
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
       
         public int ExcuteSQLUpdateBanDoc(String[] stringsSQL){
        int rowsUpdated = 0;
        String sql = "UPDATE dbo.BanDoc SET ID=?, MaDoc=?, MaSach=? ,TenNguoiDoc=?, NgayMuon=?, NgayTra=?,SoCMT=? WHERE ID=?";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            statement.setString(6, stringsSQL[5]);
            statement.setString(7, stringsSQL[6]);
            statement.setString(8, stringsSQL[7]);
            
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsUpdated;
    } 
         
             
        public int ExcuteSQLDeleteBanDoc(String[] stringsSQL){
        int rowsDeleted = 0;
        String sql = "DELETE FROM BanDoc WHERE id=?";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsDeleted;
    }
        
          public int ExcuteSQLInsertSach(String[] stringsSQL){
        int rowsInserted = 0;
        String sql = "INSERT INTO dbo.Sach( ID ,  MaSach , TenSach ,TheLoai ,NhaXuatBan ) VALUES (?,?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            
            rowsInserted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsInserted;
    }
         public int ExcuteSQLDeleteSach(String[] stringsSQL){
        int rowsDeleted = 0;
        String sql = "DELETE FROM Sach WHERE id=?";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            
            rowsDeleted = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsDeleted;
    }
         
           public int ExcuteSQLUpdateSach(String[] stringsSQL){
        int rowsUpdated = 0;
        String sql = "UPDATE dbo.Sach SET ID=?, MaSach=?, TenSach=? ,TheLoai=?, NhaXuatBan=? WHERE ID=?";
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, stringsSQL[0]);
            statement.setString(2, stringsSQL[1]);
            statement.setString(3, stringsSQL[2]);
            statement.setString(4, stringsSQL[3]);
            statement.setString(5, stringsSQL[4]);
            statement.setString(6, stringsSQL[5]);
           
            
            rowsUpdated = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class_Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsUpdated;
    } 
    
}
