package lab1;

import java.util.UUID;

public class Warehouse {
    private UUID uuid = UUID.randomUUID();
    private String address;
    private String city;
    private String country;

    public UUID getId() { return uuid; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String toString() {
        return "Id: " + uuid + "; Address: " + address + "; City: " + city + "; Country: " + country;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Warehouse other = (Warehouse) obj;
        if (this.uuid != other.uuid) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.city != null ? this.city.hashCode() : 0);
        hash = 53 * hash + this.country.hashCode();
        return hash;
    }

}

interface WarehouseBuilder {
    WarehouseBuilder setAddress(String address);
    WarehouseBuilder setCity(String city);
    WarehouseBuilder setCountry(String country);

    Warehouse build();

}

class WarehouseBuilderImpl implements WarehouseBuilder {
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
