package lab5;

import lab1.Product;
import lab1.ProductBuilderImpl;
import lab1.Warehouse;
import lab1.WarehouseBuilderImpl;
import lab3.ProductService;
import lab4.Validate;

import java.util.ArrayList;
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

        Validate val = new Validate();
        Product apple = new ProductBuilderImpl().setName("Apple").setPrice(5).setUnitsInStock(15).setWarehouse(war1).build();
        Product potato = new ProductBuilderImpl().setName("Potato").setPrice(13).setUnitsInStock(121).setWarehouse(war1).build();
        Product cucumber = new ProductBuilderImpl().setName("Cucumber").setPrice(5).setUnitsInStock(78).setWarehouse(war2).build();
        Product tomato = new ProductBuilderImpl().setName("Tomato").setPrice(16.5).setUnitsInStock(152).setWarehouse(war1).build();

        List<Product> products = new ArrayList<>();
        {
            products.add(val.validateProduct(apple));
            products.add(val.validateProduct(potato));
            products.add(val.validateProduct(cucumber));
            products.add(val.validateProduct(tomato));
        }

        StreamProductService pserv = new StreamProductService(products);

        System.out.println("Sorted products: ");
        List<Product> res = pserv.sortedProducts();
        for (var i : res) {
            System.out.println(i.toString());
        }

        System.out.println("\nSearch product: ");
        Product searchProduct = pserv.searchByName("Cucumber");
        System.out.println(searchProduct);

        System.out.println("\nPrice higher than: ");
        List<Product> priceHigherThan = pserv.priceHigherThan(12);
        for (var i : priceHigherThan) {
            System.out.println(i.toString());
        }

    }
}