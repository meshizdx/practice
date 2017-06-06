package com.spring.boot.base;

/**
 * Created by BF100177 on 2017/6/1.
 */
public class Test {

    public static void main(String[] args) {
        double ben = 3000;
        for (int i=0; i<100; i++){
            ben= ben + ben*0.04;;
        }
        System.out.println(ben);
    }

}
