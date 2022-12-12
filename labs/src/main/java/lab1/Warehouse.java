package lab1;

import java.util.ArrayList;

public class Warehouse {
    private String address;
    private String city;
    private String country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return "Address: " + address + "; City: " + city + "; Country: " + country;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
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

    public static Warehouse toObject(String string) {
        String[] str = string.split(";");
        var values = new ArrayList<String>();

        for (String item : str) {
            String[] innerItem=item.split(": ");
            values.add(innerItem[1]);
        }
        for (var i : values) {
            i.trim();
        }

        var war = new WarehouseBuilderImpl()
                .setAddress(values.get(0))
                .setCity(values.get(1))
                .setCountry(values.get(2))
                .build();

        return war;
    }


}

