package lab3;

import lab1.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public List<Product> sortedProducts() {
        products.sort(new ProductComparator());
        return products;
    }

    public Product searchByName(String name){
        for (Product product: products){
            if(product.getName() == name){
                return product;
            }
        }
        return null;
    }

    public List<Product> priceHigherThan(double price){
        List<Product> result = new ArrayList<>();
        for (Product product: products) {
            if(product.getPrice() > price){
                result.add(product);
            }
        }
        return result;
    }
}
