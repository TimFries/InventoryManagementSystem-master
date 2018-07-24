/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.BuildingInfo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tim
 */
public class BuildingInfoHandler {
    
    private static final String BUILDING_TABLE = "buildinginfo";
    
    
    public static void create(BuildingInfo data){
        
    }
    
    public static void update(BuildingInfo data){
        
    }
    
    public static void delete(BuildingInfo data){
        
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
