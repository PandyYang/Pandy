package com.pandy.java.lock;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public class Client {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                String orderNumber = orderService.getOrderNumber();
                System.out.println("orderNumber = " + orderNumber);
            }, String.valueOf(i)).start();
        }
    }
}
