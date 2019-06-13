package com.ltt.test;

import java.lang.reflect.Field;

/**
 * Created by ZJX-BJ-01-00057 on 2019/5/9.
 */
public class TestMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Product1 product1 = new Product1();

        product1.printName();

        Field field = product1.getClass().getDeclaredField("str");
        field.setAccessible(true);
        field.set(product1, new StringBuilder("456"));
        product1.printName();

//        System.out.println(product1.getClass().getDeclaredField("str").get(product1));

    }

}
