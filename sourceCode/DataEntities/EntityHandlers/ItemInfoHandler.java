/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.ItemInfo;
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
public class ItemInfoHandler {
    
    private static final String ITEM_TABLE = "iteminfo";
    
    
    public static void create(ItemInfo data){
        String sql = "INSERT into " +ITEM_TABLE+ " (itemName, itemWeight, itemDescription)"+
                                                 " Values (?, ?, ?)";
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setString(1, data.getItemName());
            stmt.setInt(2, data.getItemWeight());
            stmt.setString(3, data.getItemDescription());
            stmt.execute();
            
            
            
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    public static void delete (Integer itemID){
        String sql = "DELETE from " +ITEM_TABLE+ " WHERE itemID = ?";
        
        try(
                Connection  conn = DBUtil.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ){
            stmt.setInt(1, itemID);
            stmt.execute();
      
        }
        catch(SQLException e){
            DBUtil.processException(e);
        }
    }
    
    //TODO implement update template for ItemInfo
    public static void update(ItemInfo data){
        
    }
    
    //TODO implement List select template for ItemInfo
    public static List<ItemInfo> select(){
        List<ItemInfo> itemList = new ArrayList<>();
        
        return itemList;
    }
    
    //TODO implement single select template for ItemInfo
    public static ItemInfo select(Integer itemID){
        ItemInfo itemData = null;
        
        return itemData;
    }
    
}
