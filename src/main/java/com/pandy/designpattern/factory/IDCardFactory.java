package com.pandy.designpattern.factory;

import java.util.Vector;

/**
 * @author Pandy
 * @date 2021/3/5 16:51
 */
public class IDCardFactory extends Factory{
    private Vector owners = new Vector();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    public String toString() {
        return "IDCardFactory{" +
                "owners=" + owners +
                '}';
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product));
    }

    public Vector getOwners() {
        return owners;
    }
}
