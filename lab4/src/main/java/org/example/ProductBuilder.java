package org.example;

interface ProductBuilder {
    ProductBuilder setName(String name);
    ProductBuilder setPrice(double price);
    ProductBuilder setUnitsInStock(int unitsInStock);
    ProductBuilder setWarehouse(Warehouse warehouse);

    Product build();

}

class ProductBuilderImpl implements ProductBuilder {
    Product product = new Product();
    @Override
    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public ProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

    @Override
    public ProductBuilder setUnitsInStock(int unitsInStock) {
        product.setUnitsInStock(unitsInStock);
        return this;
    }

    @Override
    public ProductBuilder setWarehouse(Warehouse warehouse) {
        product.setWarehouse(warehouse);
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}
