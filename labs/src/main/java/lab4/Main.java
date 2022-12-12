package lab4;

import lab1.Product;
import lab1.ProductBuilderImpl;
import lab1.Warehouse;
import lab1.WarehouseBuilderImpl;

public class Main {
    public static void main(String[] args) {
        Warehouse war1 = new WarehouseBuilderImpl()
                .setAddress("Bukovinska_3")
                .setCity("Chernivtsi")
                .setCountry("Ukraine")
                .build();

        Product apple = new ProductBuilderImpl()
                .setName("Apple")
                .setPrice(5.12)
                .setUnitsInStock(15)
                .setWarehouse(war1)
                .build();

        Validate val = new Validate();
        val.validateProduct(apple);
    }


}