/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.EmployeeInfo;
import DataEntities.LoginInfo;
import Shared.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Tim
 */
public class EmployeeInfoHandler{
    
    private static final String EMPLOYEE_TABLE = "employeeinfo";
    private static final String LOGIN_TABLE = "logininfo";
    
    public static void create(EmployeeInfo data){
        String sql = "INSERT into " +EMPLOYEE_TABLE+ " (firstName, lastName, emailAddress,"
                                                   + " streetAddress, city, zipcode, state, contactPhone)"
                                                   + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, data.getFirstName());
            stmt.setString(2, data.getLastName());
            stmt.setString(3, data.getEmailAddress());
            stmt.setString(4, data.getStreetAddress());
            stmt.setString(5, data.getCity());
            stmt.setInt(6, data.getZipcode());
            stmt.setString(7, data.getState());
            stmt.setString(8, data.getContactPhone());
            stmt.execute();
            
            
            
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
        
    }
    
    //TODO implement update template for EmployeeInfo
    public static void update(EmployeeInfo data){
        
    }
    
    //TODO implement List select template for EmployeeInfo
    public static List<EmployeeInfo> select(){
       List<EmployeeInfo> employeeList = new ArrayList<>();
       
       return employeeList;
    }
    
    //TODO implement single select template for EmployeeInfo
    public static EmployeeInfo select(Integer employeeID){
        EmployeeInfo employeeData = null;
        
        return employeeData;
    }
    
    
    public static void delete(Integer employeeID){
        String sql = "DELETE FROM " +EMPLOYEE_TABLE+ " WHERE employeeID = ? LIMIT 1";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, employeeID);
            stmt.execute();
   
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static void createUser(String username, String password, String permissions, EmployeeInfo employeeData){
        String sql = "INSERT into " + LOGIN_TABLE+ " (employeeID, userName, password, permissions) "
                                                   + " VALUES ((SELECT employeeID FROM " + EMPLOYEE_TABLE
                                                   + " WHERE firstName = ? AND lastName = ? AND emailAddress = ?), ?, MD5(?), ?)";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            
            stmt.setString(1, employeeData.getFirstName());
            stmt.setString(2, employeeData.getLastName());
            stmt.setString(3, employeeData.getEmailAddress());
            stmt.setString(4, username);
            stmt.setString(5, password);
            stmt.setString(6, permissions);
            stmt.execute();
            
            
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static boolean changePassword(String newPassword){
        boolean pass = false;
        String sql = "UPDATE " +LOGIN_TABLE+ " SET password = MD5(?),"+
                                             " changePassword = ? WHERE employeeID = ?";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, newPassword);
            stmt.setInt(2, 0);
            stmt.setInt(3, LoginInfo.getEmployeeID());
            int affected = stmt.executeUpdate();
            
            if(affected == 1){
                pass = true;
            }
   
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
        return pass;
    }
    
    
    
}
