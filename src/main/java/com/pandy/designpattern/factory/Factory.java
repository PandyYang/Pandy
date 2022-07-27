package com.pandy.designpattern.factory;

/**
 * @author Pandy
 * @date 2021/3/5 16:43
 */
public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
