package com.pandy.java.thread.producerconsumer;

public class GoodsConsumer implements Runnable {
    GoodsStock goodsStock;


    public GoodsConsumer(GoodsStock goodsStock) {
        this.goodsStock = goodsStock;
    }

    @Override
    public void run() {
        while (true) {
            goodsStock.consumeGoods();
        }
    }
}
