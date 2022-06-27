package com.pandy.base.array;


public class Compute_PI {
    public static void main(String[] args) {
        Compute_PI test = new Compute_PI();

//        int i = test.sumSubString("a ", " ");
        double i =  test.calculate_it();

        System.out.println("i = " + i);
        System.out.println("i2 = " + 3.14/4);
    }

    public double calculate_it()
    {
        double x = 0.0d;
        double y = 0.0d;
        int total = 0;
        for(int i = 0;i<7000000;i++){
            x = Math.random();
            y = Math.random();
            if(Math.sqrt(x*x+y*y) < 1)
                total++;
        }
        return total/7000000.0;
    }
}
