package com.pandy.base.thread.producerconsumer;

public class GoodsProducer implements Runnable {
    GoodsStock goodsStock ;

    public GoodsProducer(){

    }
    public GoodsProducer(GoodsStock goodsStock){
        this.goodsStock = goodsStock ;
    }
    @Override
    public void run() {
        //ηδΊ§εε
        while(true){
            goodsStock.produceGoods();
        }
    }
}
