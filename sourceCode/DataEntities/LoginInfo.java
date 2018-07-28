/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities;

/**
 *
 * @author Tim
 */
public class LoginInfo {

    private static Integer employeeID;
    private static String permissions;
    private static String userName;
    private static boolean changePassword;

    public static Integer getEmployeeID() {
        return employeeID;
    }

    public static void setEmployeeID(Integer employeeID) {
        LoginInfo.employeeID = employeeID;
    }

    public static String getPermissions() {
        return permissions;
    }

    public static void setPermissions(String permissions) {
        LoginInfo.permissions = permissions;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        LoginInfo.userName = userName;
    }
    
    public static void resetLoginInfo(){
        permissions = null;
        userName = null;
        changePassword = false;
    }

    public static boolean isChangePassword() {
        return changePassword;
    }

    public static void setChangePassword(boolean changePassword) {
        LoginInfo.changePassword = changePassword;
    }
    
    

}
