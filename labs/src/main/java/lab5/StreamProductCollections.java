package lab5;

import lab1.Product;
import lab3.ProductComparator;

import java.util.List;
import java.util.stream.Collectors;

public class StreamProductCollections {
    private List<Product> products;

    public StreamProductCollections(List<Product> products) {
        this.products = products;
    }

    public List<Product> sortedProducts() {
        return products.stream().sorted(new ProductComparator()).collect(Collectors.toList());
    }

    public Product searchByName(String name){
        return products.stream().filter(product -> name.equals(product.getName()))
                .findFirst()
                .orElse(null);
    }

    public List<Product> priceHigherThan(double price){
        return products.stream().filter(product -> product.getPrice() > price).collect(Collectors.toList());
    }
}
