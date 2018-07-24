/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities.EntityHandlers;

import DataEntities.EmployeeInfo;
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
        
    }
    
    public static void update(EmployeeInfo data){
        
    }
    
    public static List<EmployeeInfo> selectAll(){
       List<EmployeeInfo> employeeList = new ArrayList<>();
       
       return employeeList;
    }
    
    public static EmployeeInfo selectOne(Integer employeeID){
        EmployeeInfo employeeData = null;
        
        return employeeData;
    }
    
    public static void delete(Integer employeeID){
        
    }
    
    public static void createUser(Integer employeeID, String username, String password, String permissions){
        
    }
    
    public static void changePassword(Integer employeeID){
        
    }
    
    
    
}
