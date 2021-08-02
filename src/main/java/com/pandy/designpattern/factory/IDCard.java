package com.pandy.designpattern.factory;

/**
 * @author Pandy
 * @date 2021/3/5 16:48
 */
public class IDCard extends Product{
    private String owner;
    IDCard(String owner) {
        System.out.println("建立" + owner + "的卡");
        this.owner = owner;
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的卡");
    }

    public String getOwner() {
        return owner;
    }
}
