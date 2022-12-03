package org.example;

public class Product {
    int id;
    Warehouse warehouse;
    String name;
    double price;
    int unitsInStock;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Warehouse getWarehouse() { return warehouse; }
    public void setWarehouse(Warehouse warehouse) { this.warehouse = warehouse; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getUnitsInStock() { return unitsInStock; }
    public void setUnitsInStock(int unitsInStock) { this.unitsInStock = unitsInStock; }

    @Override
    public String toString() {
        return "Id: " + id + "; Name: " + name + "; price: " + price + "; Units in stock: " + unitsInStock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Product other = (Product) obj;
        if (this.id != other.id) {
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
