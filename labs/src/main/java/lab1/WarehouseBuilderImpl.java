package lab1;

public class WarehouseBuilderImpl implements WarehouseBuilder {
    Warehouse warehouse = new Warehouse();

    @Override
    public WarehouseBuilder setAddress(String address) {
        warehouse.setAddress(address);
        return this;
    }

    @Override
    public WarehouseBuilder setCity(String city) {
        warehouse.setCity(city);
        return this;
    }

    @Override
    public WarehouseBuilder setCountry(String country) {
        warehouse.setCountry(country);
        return this;
    }

    @Override
    public Warehouse build() {
        return warehouse;
    }
}
