package com.pandy.java.lock;

/**
 * @author Pandy
 * @date 6/1/2022
 */
public class OrderNumberCreateUtil {

    private static int num = 0;

    public String getOrderNumber() {
        return "\t 生成订单号" + (++num);
    }
}
