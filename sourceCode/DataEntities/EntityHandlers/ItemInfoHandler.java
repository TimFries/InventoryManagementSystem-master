/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.ItemInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public class ItemInfoHandler {
    
    private static final String ITEM_TABLE = "iteminfo";
    
    
    public static void create(ItemInfo data){
        
    }
    
    public static void delete (Integer itemID){
        
    }
    
    public static void update(ItemInfo data){
        
    }
    
    public static List<ItemInfo> selectAll(){
        List<ItemInfo> itemList = new ArrayList<>();
        
        return itemList;
    }
    
    public static ItemInfo selectOne(Integer itemID){
        ItemInfo itemData = null;
        
        return itemData;
    }
    
}
