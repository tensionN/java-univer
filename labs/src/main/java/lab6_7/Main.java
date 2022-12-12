package lab6_7;

import lab1.Warehouse;
import lab1.WarehouseBuilderImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Warehouse war1 = new WarehouseBuilderImpl()
                .setAddress("Bukovinska_3")
                .setCity("Chernivtsi")
                .setCountry("Ukraine")
                .build();

        Warehouse war2 = new WarehouseBuilderImpl()
                .setAddress("South_St")
                .setCity("New York")
                .setCountry("USA")
                .build();

        DatabaseHandler dbHandler = new DatabaseHandler();
        dbHandler.createWarehouse(war1);
        List<Warehouse> warehouses = dbHandler.readWarehouses();
        for (Warehouse i : warehouses) {
           System.out.println(i.toString());
        }
        Warehouse war = dbHandler.readWarehouseById(5);
        System.out.println(war.toString());

        System.out.println(dbHandler.deleteWarehouseById(6));

        System.out.println(dbHandler.updateWarehouseById(2, war2));
    }
}