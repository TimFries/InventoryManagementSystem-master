/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities;

import java.util.List;

/**
 *
 * @author Tim
 */
public class BuildingInfo {
    
    private Integer buildingID;
    private String streetAddress;
    private String city;
    private Integer zipcode;
    private String state;
    private String contactPhone;
    private List<BuildingInventory> buildingInventory;
    private List<BuildingEmployees> buildingEmployees;

    public Integer getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Integer buildingID) {
        this.buildingID = buildingID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public List<BuildingInventory> getBuildingInventory() {
        return buildingInventory;
    }

    public void setBuildingInventory(List<BuildingInventory> buildingInventory) {
        this.buildingInventory = buildingInventory;
    }

    public List<BuildingEmployees> getBuildingEmployees() {
        return buildingEmployees;
    }

    public void setBuildingEmployees(List<BuildingEmployees> buildingEmployees) {
        this.buildingEmployees = buildingEmployees;
    }
    
    
    
    
    
}
