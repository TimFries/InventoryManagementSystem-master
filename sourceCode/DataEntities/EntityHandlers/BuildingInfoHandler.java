/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.BuildingInfo;
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
public class BuildingInfoHandler {
    
    private static final String BUILDING_TABLE = "buildinginfo";
    
    
    public static void create(BuildingInfo data){
        String sql = "INSERT into " + BUILDING_TABLE + " (streetAddress, city, zipcode, state, contactPhone)"+
                                                       " VALUES (?, ?, ?, ?, ?)";
        
        try(
                Connection conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            
            stmt.setString(1, data.getStreetAddress());
            stmt.setString(2, data.getCity());
            stmt.setInt(3, data.getZipcode());
            stmt.setString(4, data.getState());
            stmt.setString(5, data.getContactPhone());
            stmt.execute();
        }
      catch (SQLException ex) {
            DBUtil.processException(ex);
        }
    }   
    public static void update(BuildingInfo data){
        
    }
    
    public static void delete(Integer buildingID){
        String sql = "DELETE from " + BUILDING_TABLE + " WHERE buildingID = ?";
        
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, buildingID);
            stmt.execute();
   
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static List<BuildingInfo> selectAll(){
        
        List<BuildingInfo> buildingList = new ArrayList<>();
        
        return buildingList;
    }
    
    public static BuildingInfo selectOne(){
        BuildingInfo buildingData = new BuildingInfo();
        
        return buildingData;
    }
    
    
}
