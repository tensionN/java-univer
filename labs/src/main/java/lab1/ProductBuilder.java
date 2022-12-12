package lab1;

public interface ProductBuilder {
    ProductBuilder setName(String name);
    ProductBuilder setPrice(double price);
    ProductBuilder setUnitsInStock(int unitsInStock);
    ProductBuilder setWarehouse(Warehouse warehouse);

    Product build();

}

