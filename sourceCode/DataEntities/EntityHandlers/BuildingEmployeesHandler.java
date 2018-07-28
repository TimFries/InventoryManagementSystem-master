/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import Shared.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tim
 */
public class BuildingEmployeesHandler {
    
    private static final String BUILDINGEMPLOYEE_TABLE = "buildingemployees";
    
    public static void insert(Integer buildingID, Integer employeeID){
        String sql = "INSERT into " +BUILDINGEMPLOYEE_TABLE+ " (buildingID, itemID)"
                                                    + " VALUES (?, ?)";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){

            stmt.setInt(1, buildingID);
            stmt.setInt(2, employeeID);
            stmt.execute();
            
            
            
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static void delete(Integer buildingID, Integer employeeID){
        String sql = "DELETE from " + BUILDINGEMPLOYEE_TABLE + " WHERE buildingID = ? "
                                                      + " AND itemID = ?";
        
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, buildingID);
            stmt.setInt(2, employeeID);
            stmt.execute();
   
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static void update(Integer newBuildingID, Integer employeeID){
        
    }
    
    //TODO select option
    
    
}
