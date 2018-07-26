/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataEntities;

import java.sql.Timestamp;

/**
 *
 * @author Tim
 */
public class BuildingInventory {
    
    private Integer buildingID;
    private Integer itemID;
    private Integer stock;
    private Integer restockQuantity;
    private Timestamp restockDate;
    private Integer totalSold;

    public Integer getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(Integer buildingID) {
        this.buildingID = buildingID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getRestockQuantity() {
        return restockQuantity;
    }

    public void setRestockQuantity(Integer restockQuantity) {
        this.restockQuantity = restockQuantity;
    }

    public Timestamp getRestockDate() {
        return restockDate;
    }

    public void setRestockDate(Timestamp restockDate) {
        this.restockDate = restockDate;
    }

    public Integer getTotalSold() {
        return totalSold;
    }

    public void setTotalSold(Integer totalSold) {
        this.totalSold = totalSold;
    }
    
    
    
}
