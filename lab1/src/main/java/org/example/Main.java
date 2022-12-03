package org.example;

public class Main {
    public static void main(String[] args) {
        Warehouse war1 = new WarehouseBuilderImpl()
                .setAddress("Bukovinska 3")
                .setCity("Chernivtsi")
                .setCountry("Ukraine")
                .build();


        Product apple = new Product();
        apple.name = "apple";
        apple.price = 5.26;
        apple.unitsInStock = 26;
        apple.warehouse = war1;

        System.out.println(war1.toString());
        System.out.println(apple.toString());
        System.out.println(war1.hashCode());
        System.out.println(apple.hashCode());
    }


}