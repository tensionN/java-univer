package lab1;

import javax.validation.constraints.*;
import java.util.Set;

public class Product {
    @NotNull
    private Warehouse warehouse;
    @Size(min = 2, max = 24, message = "Name must be between 2 and 24 symbols")
    private String name;

    @DecimalMin(value = "0.01", message = "Must be not lower then 0.01")
    @DecimalMax(value = "1000", message = "Must be not higher then 1000")
    private double price;

    @Min(value = 0, message = "Must be not lower then 0")
    @Max(value = 10000, message = "Must be not higher then 10000")
    private int unitsInStock;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    @Override
    public String toString() {
        String productInfo = "Name: " + name + "; price: " + price + "; Units in stock: " + unitsInStock;

        String warehouseInfo = warehouse == null ? "No info" : "Address: " + warehouse.getAddress() + "; City: " + warehouse.getCity() + "; Country: " + warehouse.getCountry();

        return productInfo + "\n\t- Warehouse info: " + warehouseInfo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 53 * hash + this.unitsInStock;
        return hash;
    }


}

