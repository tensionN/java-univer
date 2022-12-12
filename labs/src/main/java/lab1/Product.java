package lab1;

import java.util.UUID;

public class Product {
    private UUID uuid = UUID.randomUUID();
    private Warehouse warehouse;
    private String name;
    private double price;
    private int unitsInStock;

    public UUID getId() { return uuid; }

    public Warehouse getWarehouse() { return warehouse; }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getUnitsInStock() { return unitsInStock; }
    public void setUnitsInStock(int unitsInStock) { this.unitsInStock = unitsInStock; }

    @Override
    public String toString() {
        String productInfo = "Id: " + uuid + "; Name: " + name + "; price: " + price + "; Units in stock: " + unitsInStock;

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

        Product other = (Product) obj;
        if (this.uuid != other.uuid) {
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

interface ProductBuilder {
    ProductBuilder setName(String name);
    ProductBuilder setPrice(double price);
    ProductBuilder setUnitsInStock(int unitsInStock);
    ProductBuilder setWarehouse(Warehouse warehouse);

    Product build();

}

class ProductBuilderImpl implements ProductBuilder {
    Product product = new Product();
    @Override
    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public ProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

    @Override
    public ProductBuilder setUnitsInStock(int unitsInStock) {
        product.setUnitsInStock(unitsInStock);
        return this;
    }

    @Override
    public ProductBuilder setWarehouse(Warehouse warehouse) {
        product.setWarehouse(warehouse);
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}
