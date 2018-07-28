/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.LoginInfo;
import Shared.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tim
 */
public class LoginInfoHandler {
    
    private static final String LOGIN_TABLE = "logininfo";
    
    public static boolean checkLogin(String username, String password){
        
        boolean pass = false;
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = createStatement(conn, username, password);
                ResultSet rs = stmt.executeQuery();
                ){
            
            if(rs.next()){
                LoginInfo.setUserName(rs.getString("userName"));
                LoginInfo.setPermissions(rs.getString("permissions"));
                LoginInfo.setChangePassword(rs.getBoolean("changePassword"));
                LoginInfo.setEmployeeID(rs.getInt("employeeID"));
                pass = true;
            }
            
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
        
        return pass;
    }
    
    private static PreparedStatement createStatement(Connection conn, String username, String password) throws SQLException{
        String sql = "SELECT userName, changePassword, permissions, employeeID FROM " +LOGIN_TABLE+
                     " WHERE userName = ? AND password = MD5(?) LIMIT 1";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        
        return stmt;
        
    }
}
