/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.BuildingInventory;
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
public class BuildingInventoryHandler {
    
    private static final String INVENTORY_TABLE = "buildinginventory";
    
    
    public static void delete(Integer buildingID, Integer itemID){
        String sql = "DELETE from " + INVENTORY_TABLE + " WHERE buildingID = ? "
                                                      + " AND itemID = ?";
        
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, buildingID);
            stmt.setInt(2, itemID);
            stmt.execute();
   
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static void insert(Integer buildingID, Integer itemID){
        String sql = "INSERT into " +INVENTORY_TABLE+ " (buildingID, itemID)"
                                                    + " VALUES (?, ?)";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){

            stmt.setInt(1, buildingID);
            stmt.setInt(2, itemID);
            stmt.execute();
            
            
            
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    //TODO implement update for BuildingInventory
    public static void update(BuildingInventory data){
        
    }
    
    //TODO implement List select for BuildingInventory
    public static List<BuildingInventory> select(Integer buildingID){
        List<BuildingInventory> inventoryList = new ArrayList<>();
        
        return inventoryList;
    }
    
}
