package com.ltt.test;

import java.lang.reflect.Field;

/**
 * Created by ZJX-BJ-01-00057 on 2019/3/14.
 */
public class FieldTest {


    /**
     * ����a��b��ֵ
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
        field.set(c,d); //ֵΪ1��λ������2����ʱ���ݷ�Χ��-128 ~ 127֮�䣬ͬʱҲ�޸��˻���Integer.cache�е���Ӧֵ
        field.set(d,temp); //��һ�����޸��˻������� 1λ�ö�Ӧ��ֵ���ĳ���2��tempȡֵ��ʱ�������Integer.valueOf()����
                            //����Integer.valueOf()�����л��ж�ֵ��Χ�� -128 ~ 127֮���ֵѡ��ӻ���ȡ��(��ϸ�ɲ鿴Դ��)

        //��ȷ���ǣ�30���޸�Ϊ��field.set(d,new Integer(temp));

    }

}
