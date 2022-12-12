package lab1;

public interface WarehouseBuilder {
    WarehouseBuilder setAddress(String address);
    WarehouseBuilder setCity(String city);
    WarehouseBuilder setCountry(String country);

    Warehouse build();
}

