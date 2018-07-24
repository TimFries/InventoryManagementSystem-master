/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities;

import java.util.Date;

/**
 *
 * @author Tim
 */
public class BuildingEmployees {
    
    private EmployeeInfo employeeInfo;
    private String employeeType;
    private Boolean tempEmployee;
    private Date employeeStarDate;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Boolean getTempEmployee() {
        return tempEmployee;
    }

    public void setTempEmployee(Boolean tempEmployee) {
        this.tempEmployee = tempEmployee;
    }

    public Date getEmployeeStarDate() {
        return employeeStarDate;
    }

    public void setEmployeeStarDate(Date employeeStarDate) {
        this.employeeStarDate = employeeStarDate;
    }
    
    
}
