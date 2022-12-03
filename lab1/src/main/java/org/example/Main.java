package org.example;

public class Main {
    public static void main(String[] args) {
        Warehouse war1 = new WarehouseBuilderImpl()
                .setAddress("Bukovinska 3")
                .setCity("Chernivtsi")
                .setCountry("Ukraine")
                .build();


        Product apple = new ProductBuilderImpl()
                .setName("Apple")
                .setPrice(5.12)
                .setUnitsInStock(15)
                .build();


        System.out.println(war1.toString());
        System.out.println(apple.toString());
        System.out.println(war1.hashCode());
        System.out.println(apple.hashCode());
    }


}