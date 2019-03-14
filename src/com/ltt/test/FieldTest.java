package com.ltt.test;

import java.lang.reflect.Field;

/**
 * Created by ZJX-BJ-01-00057 on 2019/3/14.
 */
public class FieldTest {


    /**
     * 交换a和b的值
     * @param args
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1;
        Integer b = 2;

        System.out.println("a=" + a + ",b=" + b);
        swap(a,b);
        System.out.println("a=" + a + ",b=" + b);
    }


    public static void swap(Integer c, Integer d) throws NoSuchFieldException, IllegalAccessException {
        int temp = c.intValue();
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(c,d); //值为1的位置填入2，此时数据范围在-128 ~ 127之间，同时也修改了缓存Integer.cache中的相应值
        field.set(d,temp); //上一行已修改了缓存行中 1位置对应的值，改成了2。temp取值的时候调用了Integer.valueOf()方法
                            //就是Integer.valueOf()方法中会判断值范围， -128 ~ 127之间的值选择从缓存取。(详细可查看源码)

        //正确答案是，30行修改为，field.set(d,new Integer(temp));

    }

}
