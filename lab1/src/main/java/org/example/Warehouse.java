package org.example;

public class Warehouse {
    int id;
    String address;
    String city;
    String country;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    @Override
    public String toString() {
        return "Id: " + id + "; Address: " + address + "; City: " + city + "; Country: " + country;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Warehouse other = (Warehouse) obj;
        if (this.id != other.id) {
            return false;
        }

        return true;
    }

    @Override
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
        warehouse.address = address;
        return this;
    }

    @Override
    public WarehouseBuilder setCity(String city) {
        warehouse.city = city;
        return this;
    }

    @Override
    public WarehouseBuilder setCountry(String country) {
        warehouse.country = country;
        return this;
    }

    @Override
    public Warehouse build() {
        return warehouse;
    }
}